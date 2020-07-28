package com.mindtree.poc.orderitem.controller;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.poc.orderitem.exception.ResourceNotFoundException;
import com.mindtree.poc.orderitem.model.OrderItem;
import com.mindtree.poc.orderitem.repository.OrderItemRepository;

@RestController
@RequestMapping("/api/v1")

public class OrderItemController {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@GetMapping("/orderitems")
	public List<OrderItem> getOrderItems(@RequestParam(required = false) String ids ){
		if(ids == null) {
		return orderItemRepository.findAll();
		}else {
		
		Long[] data = null;
		if(ids.contains(",")) {
			String[] values = ids.split(",");
			data = new Long[values.length];   
			for (int i = 0; i < values.length; i++) {   
			    data[i] = Long.parseLong(values[i]);   
			}
		}
		
		List<OrderItem> orderItems=  orderItemRepository.findByProductCodeIn(Arrays.asList(data));
	    return orderItems;
		}
		
	}
	
	@PostMapping("/orderitem")
	public OrderItem createOrderItem( @Valid @RequestBody OrderItem orderItem){
		return  orderItemRepository.save(orderItem);
	}
	
	@GetMapping("/orderitem/{id}")
	public ResponseEntity<OrderItem> getOrderItem(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		OrderItem emp=  orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItem Not found for this Id :"+id));
	    return new ResponseEntity(emp , HttpStatus.OK);
	}
	
	@GetMapping("/orderitems/{ids}")
	public List<OrderItem> getOrderItemsByIds(@PathVariable(value="ids") String ids) throws ResourceNotFoundException{
		
	Long[] data = null;
		if(ids.contains(",")) {
			String[] values = ids.split(",");
			data = new Long[values.length];   
			for (int i = 0; i < values.length; i++) {   
			    data[i] = Long.parseLong(values[i]);   
			}
		}
		
		List<OrderItem> orderItems=  orderItemRepository.findByProductCodeIn(Arrays.asList(data));
	    return orderItems;
	}
	
}  
