/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Distributor;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import model.DistributorModel;
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
@RequestMapping(value = "/admin/distributorManager")
public class DistributorManagerController {

    private DistributorModel disModel = new DistributorModel();

    @RequestMapping(method = RequestMethod.GET)
    public String distributorManager(ModelMap mm) {
        initData(mm);
        mm.put("title", "Distributor Manager");
        return "distributorManager";
    }

    private void initData(ModelMap mm) {
        Vector data = new Vector();
        Vector column = new Vector();
        List<Distributor> list = disModel.getAll();
        if (list.size() == 0) {
            Distributor dis = new Distributor("Auto genarate", "Auto genarate", "Auto genarate", "Auto genarate", Byte.valueOf("0"), "Auto genarate", "Auto genarate", new HashSet());
            disModel.addOrUpdate(dis);
            list = disModel.getAll();
        }

        column.add("ID");
        column.add("Name");
        column.add("Address");
        column.add("Email");
        column.add("Phone");
        column.add("Status");

        for (Distributor dis : list) {
            Vector tmp = new Vector();
            tmp.add(dis.getDistributorId());
            tmp.add("id://" + dis.getDistributorId());
            tmp.add(dis.getDisName());
            tmp.add(dis.getDisAddress());
            tmp.add(dis.getDisEmail());
            tmp.add(dis.getDisPhone());
            tmp.add(dis.getStatus() == 1 ? "Active" : "Non-Active");
            data.add(tmp);
        }
        mm.put("column", column);
        mm.put("data", data);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDistributor(@PathVariable(value = "id") int id, ModelMap mm) {
        Distributor dis = disModel.getByID(id);
        if(dis==null){
            dis=new Distributor();
            dis.setStatus(Byte.valueOf("1"));
        }
        mm.addAttribute("distributor", dis);
        return "editDistributor";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processDistributor(HttpServletRequest req,@RequestParam(value = "action") String action, @ModelAttribute(value = "distributor") Distributor dis, ModelMap mm) {
        try {
            String contextPath = req.getContextPath();
            if (action.equalsIgnoreCase("update")) {
                mm.put("check", disModel.addOrUpdate(dis));
                mm.put("alert", "Distributor Updated");
            }
            if (action.equalsIgnoreCase("Add")) {
                dis.setDistributorId(0);
                mm.put("check", disModel.addOrUpdate(dis));
                mm.put("alert", "Distributor Added");
            }
            if (action.equalsIgnoreCase("delete")) {
                mm.put("check", disModel.delete(dis));
                mm.put("alert", "Distributor Deleted");
            }
            mm.put("link", contextPath+"/admin/distributorManager.html");
        } catch (Exception ex) {
            ex.printStackTrace();
            mm.put("err", ex.getMessage());
        }
        return "processDistributor";
    }
}
