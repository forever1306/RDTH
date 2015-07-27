/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import entity.OderDetail;
import entity.OderDetailId;
import entity.Order;
import entity.Packages;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import model.CustomerModel;
import model.OrderDetailModel;
import model.OrderModel;
import model.PackageModel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/customer/packagesCustomer")
public class PackagesCustomer {

    private OrderModel orderModel = new OrderModel();
    private CustomerModel cusModel = new CustomerModel();
    private PackageModel packModel = new PackageModel();
    private OrderDetailModel orderDetailModel = new OrderDetailModel();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView packagesCustomer(Authentication authen) {
        ModelAndView model = new ModelAndView();
        model.setViewName("packagesCustomer");
        Customer cus = cusModel.find(authen.getName(), "username", false).get(0);
        int orderID = orderModel.getOrderIDByCustomer(cus.getCustomerId());
        Order od = orderModel.getByID(orderID);
        Set<OderDetail> listDetail = od.getOderDetails();
        model.addObject("listOrderDetail", listDetail);
        model.addObject("title", "My packages");
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePackage(@PathVariable int id, HttpServletRequest req, Authentication authen) {
        ModelAndView model = new ModelAndView();
        try {
            model.setViewName("deletePackage");
            Customer cus = cusModel.find(authen.getName(), "username", false).get(0);
            int orderID = orderModel.getOrderIDByCustomer(cus.getCustomerId());
            OderDetail orderDetail = orderDetailModel.getByID(new OderDetailId(orderID, id));
            if (orderDetail.getQuantity() > 1) {
                orderDetail.setQuantity(orderDetail.getQuantity() - 1);
                model.addObject("check", orderDetailModel.addOrUpdate(orderDetail));
            } else {
                model.addObject("check", orderDetailModel.delete(orderDetail));
            }
            model.addObject("alert", "Deleted");
            model.addObject("link", req.getContextPath() + "/customer/packagesCustomer.html");
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addObject("alert", "Error: " + ex.getMessage());
        }
        return model;
    }

}
