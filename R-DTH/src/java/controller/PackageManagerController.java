/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chanel;
import entity.Packages;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import model.ChanelModel;
import model.MyUtils;
import model.PackageModel;
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
@RequestMapping(value = "/admin/packageManager")
public class PackageManagerController {

    private PackageModel packageModel = new PackageModel();
    private ChanelModel chanelModel = new ChanelModel();

    @RequestMapping(method = RequestMethod.GET)
    public String packageManager(ModelMap mm) {
        initData(mm);
        mm.put("title", "Package Manager");
        return "packageManager";
    }

    private void initData(ModelMap mm) {
        Vector data = new Vector();
        Vector column = new Vector();
        List<Packages> list = packageModel.getAll();
        column.add("ID");
        column.add("Name");
        column.add("Content");
        column.add("Price");
        column.add("Status");
        column.add("Type");
        for (Packages pack : list) {
            Vector tmp = new Vector();
            tmp.add(pack.getPackageId());
            tmp.add(pack.getPackageName());
            tmp.add(pack.getPackageContent());
            tmp.add(MyUtils.getCurrencyFormat().format(pack.getPackagePrice()));
            tmp.add(pack.getStatus() == 1 ? "Active" : "Non-Active");
            tmp.add(pack.getType());
            tmp.add("id://" + pack.getPackageId());
            data.add(tmp);
        }
        mm.put("column", column);
        mm.put("data", data);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPackage(@PathVariable(value = "id") String id, ModelMap mm) {
        Packages packages = packageModel.getByID(Integer.parseInt(id));
        if(packages==null){
            packages=new Packages();
            packages.setStatus(Byte.valueOf("1"));
        }
        mm.addAttribute("packages", packages);
        List<Chanel> listChanel = chanelModel.getAll();

        mm.put("listChanel", listChanel);
        return "editPackage";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processPackage(HttpServletRequest req,ModelMap mm, @ModelAttribute(value = "packages") Packages packages, @RequestParam(value = "arrChanel", required = false) int[] arrChanel, @RequestParam(value = "action") String action
    ) {
        try{
        Set<Chanel> listChanel = new HashSet<>();
        if (arrChanel != null) {
            for (int chanelID : arrChanel) {
                Chanel chanel = new Chanel(chanelID);
                listChanel.add(chanel);
            }
        }
        packages.setChanels(listChanel);
        if (action.equalsIgnoreCase("update")) {
            mm.put("check",packageModel.addOrUpdate(packages));
            mm.put("alert", "Packge Updated");
        }
        if (action.equalsIgnoreCase("add")) {
            packages.setPackageId(0);
            mm.put("check",packageModel.addOrUpdate(packages));
            mm.put("alert", "Packge Added");
        }
        if (action.equalsIgnoreCase("delete")) {
            mm.put("check",packageModel.delete(packages));
            mm.put("alert", "Packge Deleted");
        }
        mm.put("link", req.getContextPath()+"/admin/packageManager.html");
        }catch(Exception ex){
            ex.printStackTrace();
            mm.put("err", ex.getMessage());
        }
        return "processPackage";
    }
}
