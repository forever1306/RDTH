/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Feedback;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FeedbackModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/admin/feedbackManager")
public class FeedbackControllerManager {

    private FeedbackModel feedModel = new FeedbackModel();

    @RequestMapping(method = RequestMethod.GET)
    public String feedbackManager(ModelMap mm) {
        Vector data = new Vector();
        Vector column = new Vector();
        List<Feedback> list = feedModel.getAll();
        column.add("Feedback ID");
        column.add("Customer");
        column.add("Title");
        column.add("Content");
        column.add("Feedback Date");
        column.add("Reply");
        column.add("Status");
        for (Feedback feed : list) {
            Vector tmp = new Vector();
            tmp.add(feed.getFeedId());
            tmp.add(feed.getCustomer().getCusName());
            tmp.add("id://" + feed.getFeedId());
            tmp.add(feed.getFeedTitle());
            tmp.add(feed.getFeedContent());
            tmp.add(feed.getFeedDate());
            tmp.add(feed.getFeedReply());
            
            tmp.add(feed.getStatus() == 1 ? "Replied" : "Non-reply");
            data.add(tmp);
        }
        mm.put("column", column);
        mm.put("data", data);
        mm.put("title", "Feedback Manager");
        return "feedbackManager";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editFeedback(@PathVariable(value = "id") int id, ModelMap mm) {
        Feedback feed = feedModel.getByID(id);
        mm.addAttribute("feed", feed);
        return "editFeedback";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processFeedback(HttpServletRequest req, ModelMap mm,@ModelAttribute Feedback feed) {
        try {
            String contextPath = req.getContextPath();
            feed.setStatus(Byte.valueOf("1"));
            mm.put("check", feedModel.addOrUpdate(feed));
            mm.put("alert", "Feedback Updated");
            mm.put("link", contextPath+"/admin/feedbackManager.html");

        } catch (Exception ex) {
            ex.printStackTrace();
            mm.put("err", ex.getMessage());
        }
        return "processFeedback";
    }
}
