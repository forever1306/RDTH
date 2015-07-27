/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import javax.servlet.http.HttpServletRequest;
import model.CustomerModel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/customer/changepassword")
public class ChangepasswordController {
    private CustomerModel cusModel=new CustomerModel();
    @RequestMapping(method = RequestMethod.GET)
    public String changepassword(ModelMap mm){
        mm.put("title", "Change Password");
        return "changepassword";
    }
    @RequestMapping(value = "/process",method = RequestMethod.POST)
    public String changepassProcess(Authentication authen,@RequestParam String newpass,@RequestParam String oldpass,ModelMap mm,HttpServletRequest req){
        Customer cus= cusModel.find(authen.getName(), "username", false).get(0);
        if(!cus.getPassword().equals(oldpass)){
            mm.put("check",true);
            mm.put("alert", "Old password invalid");
            mm.put("link", req.getContextPath()+"/customer/changepassword.html");
        }else{
            cus.setPassword(newpass);
            mm.put("check",cusModel.addOrUpdate(cus));
            mm.put("alert", "Password updated");
            mm.put("link", req.getContextPath());
        }
        return "changepassProcess";
    }
}
