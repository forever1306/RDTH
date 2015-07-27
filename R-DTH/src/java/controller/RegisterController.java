/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import javax.servlet.http.HttpServletRequest;
import model.CustomerModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private CustomerModel cusModel = new CustomerModel();

    @RequestMapping(method = RequestMethod.GET)
    public String register(ModelMap mm) {
        mm.put("title", "Register");
        mm.addAttribute("customer", new Customer());
        return "register";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processRegister(ModelMap mm, @ModelAttribute(value = "customer") Customer customer,HttpServletRequest req) {
        try {
            customer.setStatus(Byte.valueOf("1"));
            if(cusModel.find(customer.getUsername(), "username", false).size()>0){
                 mm.put("msg", "Username exits");
                 mm.put("location", req.getContextPath()+"/register.html");
                 return "processRegister";
            }
            if (cusModel.addOrUpdate(customer)) {
                mm.put("msg", "Register Success");
                mm.put("location", req.getContextPath());
            }
        } catch (Exception ex) {
            mm.put("msg", ex.getMessage());
        }
        return "processRegister";
    }
}
