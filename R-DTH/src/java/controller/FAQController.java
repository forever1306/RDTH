/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Faq;
import java.util.List;
import model.FAQModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/FAQViews")
public class FAQController {
    private FAQModel fModel=new FAQModel();
    @RequestMapping(method = RequestMethod.GET)
    public String FAQViews(ModelMap mm){
        List<Faq>list=fModel.find(Byte.valueOf("1"), "status", false);
        mm.put("listFAQ", list);
        mm.put("title", "FAQ");
        return "FAQViews";
    }
}
