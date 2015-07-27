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
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import model.CustomerModel;
import model.OrderDetailModel;
import model.OrderModel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/customer/payment")
public class PaymentController {

    private OrderDetailModel dtModel = new OrderDetailModel();
    private OrderModel orderModel = new OrderModel();
    private CustomerModel cusModel = new CustomerModel();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView payment(Authentication authen) {
        ModelAndView model = new ModelAndView();
        try {
            model.setViewName("payment");
            double sum = 0;
            Customer cus = cusModel.find(authen.getName(), "username", false).get(0);
            int orderID = orderModel.getOrderIDByCustomer(cus.getCustomerId());
            Order od = orderModel.getByID(orderID);
            Set<OderDetail> listDetail = od.getOderDetails();
            for (OderDetail detail : listDetail) {
                sum += detail.getPrice() * detail.getQuantity();
            }
            model.addObject("listDetail", listDetail);
            model.addObject("sum", sum);
            model.addObject("title", "Payment");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public ModelAndView processPayment(Authentication authen, HttpServletRequest req, @RequestParam int month) {
        ModelAndView model = new ModelAndView();
        try {
            model.setViewName("processPayment");
            Customer cus = cusModel.find(authen.getName(), "username", false).get(0);
            int orderID = orderModel.getOrderIDByCustomerNonActive(cus.getCustomerId());
            int orderIDActive = orderModel.getOrderIDByCustomer(cus.getCustomerId());
            Order order = orderModel.getByID(orderID);
            Order orderActive=orderModel.getByID(orderIDActive);
            if (order.getStatus() == 1) {
                order.setOderId(0);
                Calendar ca = Calendar.getInstance();
                ca.setTime(orderActive.getOrderExpiredDate());
                ca.add(Calendar.MONTH, month);
                order.setOrderExpiredDate(new Date(ca.getTimeInMillis()));
            } else {
                Calendar ca = Calendar.getInstance();
                ca.setTime(orderActive.getOrderExpiredDate());
                ca.add(Calendar.MONTH, month);
                order.setOrderExpiredDate(ca.getTime());
            }
            order.setOrderPaymentDate(new Date());

            order.setStatus((byte) 0);
            Set<OderDetail> listOrderDetail = order.getOderDetails();
            orderModel.addOrUpdate(order);

            for (OderDetail orderdetail : listOrderDetail) {
                orderdetail.setId(new OderDetailId(order.getOderId(), orderdetail.getId().getPackageId()));
            }
            model.addObject("check", orderModel.addOrUpdate(order));
            model.addObject("alert", "Send request success");
            model.addObject("link", req.getContextPath() + "/index.html");
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addObject("alert", "Error: " + ex.getMessage());
        }
        return model;
    }
}
