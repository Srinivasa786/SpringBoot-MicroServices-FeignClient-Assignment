package com.mindtree.poc.orderitem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Item")
public class OrderItem {

    private long productCode;
    private String productName;
    private Integer quantity;
 
    public OrderItem() {
  
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Product_Code")
        public long getProductCode() {
        return productCode;
    }
    public void setProductCode(long productCode) {
        this.productCode = productCode;
    }
 
    @Column(name = "Product_Name", nullable = false)
    public String getproductName() {
        return productName;
    }
    public void setproductName(String productName) {
        this.productName = productName;
    }
 
    @Column(name = "Quantity", nullable = false)
    public Integer getquantity() {
        return quantity;
    }
    public void setquantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity  
       + "]";
    }
 
}
