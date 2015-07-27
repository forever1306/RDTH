/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import entity.Feedback;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.CustomerModel;
import model.FeedbackModel;
import org.springframework.security.core.Authentication;
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
@RequestMapping(value = "/customer/feedback")
public class FeedbackController {
    private FeedbackModel feedModel=new FeedbackModel();
    private CustomerModel cusModel=new CustomerModel();
    @RequestMapping(method = RequestMethod.GET)
    public String feedback(ModelMap mm,Authentication authen){
        Customer cus=cusModel.find(authen.getName(), "username", false).get(0);
        
        List<Feedback> listFeed=feedModel.find(cus, "customer", false);
        mm.put("listFeed", listFeed);
        mm.put("title", "Feedback");
        return "feedback";
    }
    @RequestMapping(value = "/addFeedback",method = RequestMethod.GET)
    public String addFeedback(ModelMap mm){
        mm.put("title", "Send Feedback");
        mm.addAttribute("feed", new Feedback());
        return "addFeedback";
    }
    @RequestMapping(value = "/process",method = RequestMethod.POST)
    public String processAddFeedback(ModelMap mm,@ModelAttribute Feedback feed,Authentication authen,HttpServletRequest req){
        try{
        Customer cus=cusModel.find(authen.getName(), "username", false).get(0);
        feed.setFeedDate(new Timestamp(new Date().getTime()));
        feed.setCustomer(cus);
        feed.setStatus(Byte.valueOf("0"));
        mm.put("check",feedModel.addOrUpdate(feed));
        mm.put("alert","Feedback has send");
        mm.put("link", req.getContextPath()+"/customer/feedback.html");
        }catch(Exception ex){
            ex.printStackTrace();
            mm.put("err", ex.getMessage());
        }
        return "processAddFeedback";
    }
    
}
