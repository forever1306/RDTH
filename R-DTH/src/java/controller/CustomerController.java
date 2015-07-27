/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import model.CustomerModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping(value = "/admin/customerManager")
public class CustomerController {

    private CustomerModel cusModel = new CustomerModel();

    private void initData(ModelMap mm) {
        mm.put("title", "Customer Manager");
        List<Customer> list = cusModel.getAll();
        Vector data = new Vector();
        Vector column = new Vector();
        column.add("Name");
        column.add("Address");
        column.add("Email");
        column.add("Card Number");
        column.add("Status");
        for (Customer cus : list) {
            Vector tmp = new Vector();
            tmp.add(cus.getCusName());
            tmp.add(cus.getAddress());
            tmp.add(cus.getEmail());
            tmp.add(cus.getBankCardNumber());
            tmp.add(cus.getStatus() == 1 ? "Active" : "Non-Active");
            tmp.add("id://" + cus.getCustomerId());
            data.add(tmp);

        }
        mm.put("column", column);
        mm.put("data", data);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String customerManager(ModelMap mm) {
        initData(mm);
        return "customerManager";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(ModelMap mm, @PathVariable(value = "id") String id) {
        Customer customer = cusModel.getByID(id);
        if(customer==null){
            customer=new Customer();
        }
        mm.addAttribute("customer", customer);
        return "editCustomer";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processCustomer(HttpServletRequest req, @ModelAttribute(value = "customer") Customer customer, @RequestParam(value = "action", required = false) String action, ModelMap mm) {
        try {

            String contextPath = req.getContextPath();
            Customer customerNon = cusModel.getByID(customer.getCustomerId());
            if (action.equalsIgnoreCase("update")) {
                customerNon.setStatus(customer.getStatus());
                customerNon.setPassword(customer.getPassword());
                mm.put("check", cusModel.addOrUpdate(customerNon));
                mm.put("alert", "Customer Updated");
            }
            if (action.equalsIgnoreCase("delete")) {
                mm.put("check",cusModel.delete(customerNon));
                mm.put("alert", "Customer Deleted");
            }
            mm.put("link", contextPath+"/admin/customerManager.html");
        } catch (Exception ex) {
            ex.printStackTrace();
            mm.put("err", ex.getMessage());
        }
        return "processCustomer";
    }
}
