/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chanel;
import entity.Customer;
import entity.Distributor;
import entity.OderDetail;
import entity.OderDetailId;
import entity.Order;
import entity.Packages;
import entity.Product;
import entity.Requirement;
import entity.RequirementId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CustomerModel;
import model.DistributorModel;
import model.OrderModel;
import model.PackageModel;
import model.ProductModel;
import model.RequirementModel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Minh-IT
 */
@Controller
@RequestMapping(value = "/viewPackage")
public class ViewPackageController {

    private final PackageModel packModel = new PackageModel();
    private final DistributorModel disModel = new DistributorModel();
    private final CustomerModel cusModel = new CustomerModel();
    private final ProductModel pmodel = new ProductModel();
    private final OrderModel orderModel = new OrderModel();
    private final RequirementModel requirementModel = new RequirementModel();

    @RequestMapping(method = RequestMethod.GET)
    public String viewPackage(ModelMap mm) {
        List<Packages> list = packModel.find(Byte.valueOf("1"), "status", false);
        mm.put("listPackage", list);
        mm.put("title", "View package");
        return "viewPackage";
    }

    @RequestMapping(value = "/viewChanel/{id}", method = RequestMethod.GET)
    public String viewChanel(ModelMap mm, @PathVariable(value = "id") int id) {
        Packages packages = packModel.getByID(id);
        Set<Chanel> listChanel = packages.getChanels();
        mm.put("listChanel", listChanel);
        return "viewChanel";
    }

    @RequestMapping(value = "/pickPackage/{id}", method = RequestMethod.GET)
    public String pickPackage(ModelMap mm, Authentication authen, @PathVariable(value = "id") int id) {
        try {
            List<Distributor> listDis = disModel.getAll();
            Packages pack = packModel.getByID(id);
            mm.put("listDistributor", listDis);
            Customer cus = cusModel.find(authen.getName(), "username", false).get(0);
            mm.addAttribute("requirement", new Requirement(null, cus, null, Double.NaN));
            mm.put("type", pack.getType());
            mm.put("packid", pack.getPackageId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "pickPackage";

    }

    @RequestMapping(value = "/showProduct/{disID}/{type}", method = RequestMethod.GET)
    public String showProduct(ModelMap mm, @ModelAttribute(value = "Requirement") Requirement requirement, @PathVariable(value = "disID") int disID, @PathVariable(value = "type") int type) {
        Distributor dis = disModel.getByID(disID);
        Set<Product> listProduct = dis.getProducts();
        List<Product> listProductByType = new ArrayList<>();
        Product pro = new Product();
        pro.setProductName("None");
        listProductByType.add(pro);
        for (Product p : listProduct) {
            if (p.getType() >= type) {
                listProductByType.add(p);
            }
        }
        mm.put("listProduct", listProductByType);
        mm.addAttribute("requirement", requirement);
        return "showProduct";
    }

    @RequestMapping(value = "/addToOrder/{packageID}/{productID}", method = RequestMethod.GET)
    public String addToOrder(Authentication authen, HttpServletRequest req, ModelMap mm, @PathVariable(value = "packageID") int packageID, @PathVariable(value = "productID") int productID) {
        try {
            LinkedHashMap<OderDetail, Requirement> orderSession = null;
            HttpSession session = req.getSession();
            Packages pack = packModel.getByID(packageID);
            Product product = pmodel.getByID(productID);
            Customer customer = cusModel.find(authen.getName(), "username", false).get(0);
            OderDetail od = new OderDetail();
            od.setPackages(pack);
            od.setPrice(pack.getPackagePrice());
            od.setQuantity(1);

            Requirement rq = null;
            if (product != null) {
                rq = new Requirement(new RequirementId(product.getProductId(), customer.getCustomerId(), "generic"+new Random().nextInt()), customer, product, product.getProductPrice());
            }
            if (session.getAttribute("orderSession") == null) {
                orderSession = new LinkedHashMap<>();
                orderSession.put(od, rq);
                session.setAttribute("orderSession", orderSession);
            } else {
                boolean ck = false;
                orderSession = (LinkedHashMap<OderDetail, Requirement>) session.getAttribute("orderSession");
                for (OderDetail orderDt : orderSession.keySet()) {
                    if (orderDt.getPackages().getPackageId() == od.getPackages().getPackageId()) {
                        orderDt.setQuantity(orderDt.getQuantity() + 1);
                        ck = true;
                        break;
                    }
                }
                if (!ck) {
                    orderSession.put(od, rq);
                }
                session.setAttribute("orderSession", orderSession);
            }
            mm.put("msg", "Added");
        } catch (Exception ex) {
            ex.printStackTrace();
            mm.put("msg", ex.getMessage());
        }
        return "addToOrder";
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public String createOrder(HttpServletRequest req, ModelMap mm, Authentication authen) {
        try {
            LinkedHashMap<OderDetail, Requirement> orderSession = null;
            orderSession = (LinkedHashMap<OderDetail, Requirement>) req.getSession().getAttribute("orderSession");
            if (orderSession == null) {
                mm.put("msg", "No Package choosed");
                return "createOrder";
            } else {
                Set<OderDetail> listOrderDetail = new HashSet<>();
                Set<Requirement> listRequirement = new HashSet<>();
                listOrderDetail = orderSession.keySet();
                for (Requirement rq : orderSession.values()) {
                    if (rq != null) {
                        listRequirement.add(rq);
                    }
                }
                Customer customer = cusModel.find(authen.getName(), "username", false).get(0);
                customer.setRequirements(listRequirement);
                Calendar c = Calendar.getInstance();
                c.add(Calendar.MONTH, 1);
                Order order=null;
                int orderID=orderModel.getOrderIDByCustomerNonActive(customer.getCustomerId());
                if(orderID==0){
                order = new Order(customer, new Date(), c.getTime(), Byte.valueOf("0"), null);
                orderModel.addOrUpdate(order);
                }else{
                    order=orderModel.getByID(orderID);
                }
                Set<OderDetail> listDetailTmp=order.getOderDetails();
                for (OderDetail od : listOrderDetail) {
                    od.setId(new OderDetailId(order.getOderId(), od.getPackages().getPackageId()));
                    for(OderDetail tmp:listDetailTmp){
                        if(od.getPackages().getPackageId()==tmp.getPackages().getPackageId()){
                            od.setQuantity(od.getQuantity()+1);
                            break;
                        }
                    }
                }
                order.setOderDetails(listOrderDetail);

                orderModel.addOrUpdate(order);
                cusModel.addOrUpdate(customer);

                req.getSession().setAttribute("orderSession", null);
                mm.put("msg", "Order Created");
            }
        } catch (Exception ex) {
            mm.put("msg", ex.getMessage());
        }
        return "createOrder";
    }
}
