/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import entity.Order;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import model.CustomerModel;
import model.OrderModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/admin/orderManager")
public class OrderManagerController {

    private OrderModel orderModel = new OrderModel();
    private CustomerModel customerModel = new CustomerModel();

    @RequestMapping(method = RequestMethod.GET)
    public String orderManager(ModelMap mm) {
        initData(mm);
        mm.put("title", "Order Manager");
        return "orderManager";
    }

    private void initData(ModelMap mm) {
        Vector data = new Vector();
        Vector column = new Vector();
        List<Order> list = orderModel.getAll();
        column.add("Order ID");
        column.add("Payment Date");
        column.add("Expired Date");
        column.add("Status");

        for (Order od : list) {
            Vector tmp = new Vector();
            tmp.add(od.getOderId());
            tmp.add(od.getOrderPaymentDate());
            tmp.add(od.getOrderExpiredDate());
            tmp.add(od.getStatus() == 1 ? "Processed" : "Pending");
            tmp.add("id://" + od.getOderId());
            data.add(tmp);
        }
        mm.put("column", column);
        mm.put("data", data);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editOrder(ModelMap mm, @PathVariable(value = "id") int id) {
        Order od = orderModel.getByID(id);
        if (od != null) {
            Customer cus = customerModel.getByID(od.getCustomer().getCustomerId());
            long crDate=od.getOrderPaymentDate().getTime();
            long exDate=od.getOrderExpiredDate().getTime();
            Calendar month=Calendar.getInstance();
            month.setTimeInMillis(exDate-crDate);
            
            mm.put("month", month.get(Calendar.MONTH));
            mm.put("customer", cus);
            mm.addAttribute("order", od);
        }
        return "editOrder";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processOrder(HttpServletRequest req, ModelMap mm,@RequestParam int oderId,@RequestParam byte status) {
        try {
            Order order=orderModel.getByID(oderId);
            order.setStatus(status);
            mm.put("check",orderModel.addOrUpdate(order));
            mm.put("alert","Updated");
            mm.put("link", req.getContextPath()+"/admin/orderManager.html");

        } catch (Exception ex) {
            ex.printStackTrace();
            mm.put("alert", ex.getMessage());
        }
        return "processOrder";
    }
}
