package entity;
// Generated Jul 1, 2015 8:33:56 AM by Hibernate Tools 4.3.1



/**
 * Requirement generated by hbm2java
 */
public class Requirement  implements java.io.Serializable {


     private RequirementId id;
     private Customer customer;
     private Product product;
     private Double price;

    public Requirement() {
    }

	
    public Requirement(RequirementId id, Customer customer, Product product) {
        this.id = id;
        this.customer = customer;
        this.product = product;
    }
    public Requirement(RequirementId id, Customer customer, Product product, Double price) {
       this.id = id;
       this.customer = customer;
       this.product = product;
       this.price = price;
    }
   
    public RequirementId getId() {
        return this.id;
    }
    
    public void setId(RequirementId id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }




}


