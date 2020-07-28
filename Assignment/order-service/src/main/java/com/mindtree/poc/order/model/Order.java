package com.mindtree.poc.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_INFO")
public class Order {

    private long orderID;
    private String customerName;
    private String orderDate;
    private String shippingAddress;
    private String orderItems;
    private Integer total;
    
    public Order() {
  
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Order_ID")
        public long getorderID() {
        return orderID;
    }
    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }
 
    @Column(name = "Customer_Name", nullable = false)
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    
    @Column(name = "Order_Date", nullable = false)
    public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Column(name = "total", nullable = false)
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    
    @Column(name = "Shipping_Address", nullable = false)
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	@Column(name = "Order_Items", nullable = false)
	public String getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(String orderItems) {
		this.orderItems = orderItems;
	}

}
