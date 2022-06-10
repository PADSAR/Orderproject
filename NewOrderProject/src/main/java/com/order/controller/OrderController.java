package com.order.controller;


import com.order.exceptions.NoSuchOrderFound;
import com.order.exceptions.OrderWithIdAlreadyExist;
import com.order.model.Order;
import com.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@GetMapping("/allorders")
	public Iterable<Order> getAllOrder(){
		return service.getOrderList();
	}
	
	@PutMapping(path = "{orderid}", consumes = "application/json")
	public void updatedOrder(@PathVariable("orderid") int orderid,@RequestBody Order order ) throws NoSuchOrderFound{
		service.updateOrder(orderid, order);
		
	}
	@PostMapping(path="") 
	public String addOrder(@RequestBody Order order) throws OrderWithIdAlreadyExist{
		service.createOrder(order);
		return "Order id "+order.getOrderId()+" placed";
		
	}
	@DeleteMapping(path= "/deleteorder/{orderid}")
	public String deleteOrder(@PathVariable("orderid") int orderid) throws NoSuchOrderFound{
		service.deleteOrder(orderid);
		return "The order id no."+orderid+"deleted";
		
	}
	

}
