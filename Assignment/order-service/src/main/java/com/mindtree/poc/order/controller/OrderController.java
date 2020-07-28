package com.mindtree.poc.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.poc.order.domain.OrderInfo;
import com.mindtree.poc.order.exception.ResourceNotFoundException;
import com.mindtree.poc.order.model.Order;
import com.mindtree.poc.order.proxy.OrderItem;
import com.mindtree.poc.order.proxy.OrderItemServiceProxy;
import com.mindtree.poc.order.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired  
	private OrderItemServiceProxy proxy; 
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/orders")
	public List<Order> getOrders(){
		
		return orderRepository.findAll();
		
	}
	
	@PostMapping("/order")
	public Order createOrder( @Valid @RequestBody Order Order){
		return  orderRepository.save(Order);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<OrderInfo> getOrder(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		Order emp=  orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order Not found for this Id :"+id));
		
		List<OrderItem> retrieveOrderItems = proxy.retrieveOrderItems(emp.getOrderItems());
		return new ResponseEntity(new OrderInfo(emp , retrieveOrderItems) , HttpStatus.OK);
	}
	
	
	
	
	
}
