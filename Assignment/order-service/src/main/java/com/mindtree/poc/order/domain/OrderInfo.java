package com.mindtree.poc.order.domain;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.poc.order.model.Order;
import com.mindtree.poc.order.proxy.OrderItem;

public class OrderInfo {
	
	private Order order;
	private List<OrderItem> items;
	
	
	public OrderInfo(Order order, List<OrderItem> retrieveOrderItems) {
		super();
		this.order = order;
		this.items = retrieveOrderItems;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderItem> getItems() {
		if(items == null) {
			items = new ArrayList<>();
		}
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	
	

}
