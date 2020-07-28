package com.mindtree.poc.order.proxy;

public class OrderItem {

    private long productCode;
    private String productName;
    private Integer quantity;
    
 
    public OrderItem() {
  
    }

	public OrderItem(long productCode, String productName, Integer quantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
