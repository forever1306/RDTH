/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Faq;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import model.FAQModel;
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
@RequestMapping(value = "/admin/FAQManager")
public class FAQManagerController {
    private FAQModel faqModel=new FAQModel();
    
    @RequestMapping(method = RequestMethod.GET)
    public String FAQManager(ModelMap mm){
        initData(mm);
        mm.put("title", "FAQ Manager");
        return "FAQManager";
    }
    
    private void initData(ModelMap mm){
        Vector data=new Vector();
        Vector column=new Vector();
        List<Faq> list=faqModel.getAll();
        if(list.size()==0){
            Faq f=new Faq("Auto Generate", "Auto Generate", Byte.valueOf("0"));
            faqModel.addOrUpdate(f);
            list.add(f);
        }
        
        column.add("ID");
        column.add("Question");
        column.add("Answer");
        column.add("Status");
        for(Faq f:list){
            Vector tmp=new Vector();
            tmp.add(f.getFaqId());
            tmp.add(f.getFaqQestion());
            tmp.add(f.getFaqAnswer());
            tmp.add(f.getStatus()==1?"Active":"Non-Active");
            tmp.add("id://"+f.getFaqId());
            data.add(tmp);
        }
        mm.put("column", column);
        mm.put("data", data);
        
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editFAQ(@PathVariable(value = "id") int id,ModelMap mm){
        Faq f=faqModel.getByID(id);
        if(f==null){
            f=new Faq();
            f.setStatus(Byte.valueOf("1"));
        }
        mm.addAttribute("FAQ", f);
        return "editFAQ";
    }
    @RequestMapping(value = "/process")
    public String processFAQ(HttpServletRequest req,@ModelAttribute(value = "FAQ") Faq f,@RequestParam(value = "action") String action,ModelMap mm){
        try{
            String contextPath=req.getContextPath();
        if(action.equalsIgnoreCase("update")){
            mm.put("check",faqModel.addOrUpdate(f));
            mm.put("alert", "FAQ Updated");
        }if(action.equalsIgnoreCase("Add")){
            f.setFaqId(0);
            mm.put("check",faqModel.addOrUpdate(f));
            mm.put("alert", "FAQ Added");
        }if(action.equalsIgnoreCase("delete")){
            mm.put("check",faqModel.delete(f));
            mm.put("alert", "FAQ Deleted");
        }
        mm.put("link", contextPath+"/admin/FAQManager.html");
        }catch(Exception ex){
            ex.printStackTrace();
            mm.put("err", ex.getMessage());
        }
        return "processFAQ";
    }
}
