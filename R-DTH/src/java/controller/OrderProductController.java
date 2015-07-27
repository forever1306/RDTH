/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Distributor;
import entity.Product;
import entity.Requirement;
import entity.RequirementId;
import java.text.NumberFormat;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import model.CustomerModel;
import model.DistributorModel;
import model.ProductModel;
import model.RequirementModel;
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
@RequestMapping(value = "/distributor/orderProduct")
public class OrderProductController {

    private RequirementModel rqModel = new RequirementModel();
    private ProductModel proModel = new ProductModel();
    private CustomerModel cusModel = new CustomerModel();
    private DistributorModel disModel = new DistributorModel();
    private NumberFormat nformat = NumberFormat.getCurrencyInstance();

    @RequestMapping(method = RequestMethod.GET)
    public String orderProduct(Authentication authen, ModelMap mm) {
        Distributor dis = disModel.find(authen.getName(), "username", false).get(0);
        List<Product> listProduct = proModel.find(dis, "distributor", false);
        Vector data = new Vector();
        Vector column = new Vector();
        column.add("Product Name");
        column.add("Customer Name");
        column.add("Serial");
        column.add("Price");
        for (Product p : listProduct) {
            List<Requirement> listReq = rqModel.find(p, "product", false);
            for (Requirement requirement : listReq) {
                if (requirement != null) {
                    Vector tmp = new Vector();
                    tmp.add(requirement.getProduct().getProductName());
                    tmp.add("id://" + requirement.getId().getProductId() + ":" + requirement.getId().getCustomerId() + ":" + requirement.getId().getSerial());
                    tmp.add(requirement.getCustomer().getCusName());
                    tmp.add(requirement.getId().getSerial());
                    tmp.add(nformat.format(requirement.getPrice()));
                    data.add(tmp);
                }
            }
        }
        mm.put("column", column);
        mm.put("data", data);
        mm.put("title", "Order Product Manager");
        return "orderProduct";
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editOrderProduct(@PathVariable String id,ModelMap mm){
        int productID=Integer.parseInt(id.split(":")[0]);
        String customerID=id.split(":")[1];
        String serial=id.split(":")[2];
        RequirementId rid=new RequirementId(productID, customerID, serial);
        Requirement requirement=rqModel.getByID(rid);
        mm.addAttribute("req", requirement);
        return "editOrderProduct";
    }
    @RequestMapping(value = "/process",method = RequestMethod.POST)
    public String processOrderProduct(ModelMap mm,@ModelAttribute Requirement req,HttpServletRequest request,@RequestParam String seri){
        try{
            mm.put("check", rqModel.updateSerial(req.getId(), seri));
            mm.put("alert", "Updated");
            mm.put("link", request.getContextPath()+"/distributor/orderProduct.html");
        }catch(Exception ex){
            mm.put("err", ex.getMessage());
        }
        return "processOrderProduct";
    }
}
