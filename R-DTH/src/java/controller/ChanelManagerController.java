/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chanel;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import model.ChanelModel;
import model.MyUtils;
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
@RequestMapping(value = "/admin/chanelManager")
public class ChanelManagerController {

    private ChanelModel chanelModel = new ChanelModel();

    @RequestMapping(method = RequestMethod.GET)
    public String chanelManager(ModelMap mm) {
        initData(mm);
        mm.put("title", "Chanel Manager");
        return "chanelManager";
    }

    private void initData(ModelMap mm) {
        Vector data = new Vector();
        Vector column = new Vector();
        List<Chanel> list = chanelModel.getAll();
        column.add("ID");
        column.add("Chanel Name");
        column.add("Chanel Price");
        column.add("Content");

        for (Chanel cl : list) {
            Vector tmp = new Vector();
            tmp.add(cl.getChanelId());
            tmp.add(cl.getChanelName());
            tmp.add(MyUtils.getCurrencyFormat().format(cl.getChanelPrice()));
            tmp.add(cl.getChanelContent());
            tmp.add("id://" + cl.getChanelId());
            data.add(tmp);
        }
        mm.put("column", column);
        mm.put("data", data);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editCustomer(@PathVariable(value = "id") String id, ModelMap mm) {
        try {
            Chanel cl = chanelModel.getByID(Integer.parseInt(id));
            if (cl == null) {
                cl = new Chanel();
            }
            mm.addAttribute("chanel", cl);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "editChanel";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processChanel(HttpServletRequest req, @ModelAttribute(value = "chanel") Chanel cl, @RequestParam(value = "action") String action, ModelMap mm) {
        try {
            String contextPath = req.getContextPath();
            if (action.equalsIgnoreCase("update")) {
                mm.put("check", chanelModel.addOrUpdate(cl));
                mm.put("alert", "Chanel Updated");

            }
            if (action.equalsIgnoreCase("add")) {
                cl.setChanelId(0);
                mm.put("check", chanelModel.addOrUpdate(cl));
                mm.put("alert", "Chanel Added");
            }
            if (action.equalsIgnoreCase("delete")) {
                mm.put("check", chanelModel.delete(cl));
                mm.put("alert", "Chanel Deleted");
            }
            mm.put("link", contextPath + "/admin/chanelManager.html");
        } catch (Exception ex) {
            ex.printStackTrace();
            mm.put("err", ex.getMessage());
        }
        return "processChanel";
    }
}
