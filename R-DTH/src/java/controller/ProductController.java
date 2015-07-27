/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Distributor;
import entity.Product;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DistributorModel;
import model.ProductModel;
import org.springframework.security.core.Authentication;
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
@RequestMapping(value = "/distributor/productManager")
public class ProductController {

    ProductModel pModel = new ProductModel();
    DistributorModel disModel = new DistributorModel();

    @RequestMapping(method = RequestMethod.GET)
    public String productManager(ModelMap mm, Authentication authen) {
        String username = authen.getName();
        Distributor dis = disModel.find(username, "username", false).get(0);
        List<Product> list = pModel.find(dis, "distributor", false);
        if (list.size() == 0) {
            Product p = new Product(new Distributor(dis.getDistributorId()), "Autogeneric", 0d,Byte.valueOf("1"), null);
            pModel.addOrUpdate(p);
            list = pModel.find(dis, "distributor", false);
        }
        Vector data = new Vector();
        Vector column = new Vector();
        column.add("Product ID");
        column.add("Product Name");
        column.add("Product Price");
        column.add("Product Type");

        for (Product p : list) {
            Vector tmp = new Vector();
            tmp.add(p.getProductId());
            tmp.add("id://" + p.getProductId());
            tmp.add(p.getProductName());
            tmp.add(p.getProductPrice());
            tmp.add(p.getType());
            data.add(tmp);
        }
        mm.addAttribute("column", column);
        mm.addAttribute("data", data);
        mm.put("title", "Product Manager");
        return "productManager";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editProduct(ModelMap mm, @PathVariable(value = "id") int id) {
        Product product = pModel.getByID(id);
        if(product==null){
            product=new Product();
        }
        mm.addAttribute("product", product);
        return "editProduct";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processProduct(HttpServletRequest req, ModelMap mm, HttpServletResponse res, @ModelAttribute(value = "product") Product product, @RequestParam(value = "action") String action) {
        try {
            if (action.equalsIgnoreCase("update")) {
                mm.put("check",pModel.addOrUpdate(product));
                mm.put("alert", "Product Updated");
            }
            if (action.equalsIgnoreCase("add")) {
                product.setProductId(0);
                mm.put("check",pModel.addOrUpdate(product));
                mm.put("alert", "Product Added");
            }
            if (action.equalsIgnoreCase("delete")) {
                mm.put("check", pModel.delete(product));
                mm.put("alert", "Chanel Deleted");
            }
            mm.put("link",req.getContextPath() + "/distributor/productManager.html");
        } catch (Exception ex) {
            ex.printStackTrace();
            mm.put("err", ex.getMessage());
        }
        return "processProduct";
    }
}
