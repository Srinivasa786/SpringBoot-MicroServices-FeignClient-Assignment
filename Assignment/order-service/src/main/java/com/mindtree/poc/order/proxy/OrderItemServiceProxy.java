package com.mindtree.poc.order.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="order-item-service", url="localhost:8080") 
public interface OrderItemServiceProxy {

	@GetMapping("/orderitemservice/api/v1/orderitems")		
	public List<OrderItem> retrieveOrderItems(@RequestParam("ids") String ids); 
	
}
