package com.order.service;

import java.util.Optional;

import com.order.exceptions.NoSuchOrderFound;
import com.order.exceptions.OrderWithIdAlreadyExist;
import com.order.model.Order;
import com.order.repository.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrdersRepository repository;

	@Override
	public Iterable<Order> getOrderList() {
		return repository.findAll();
	}

	@Override
	public String updateOrder(int orderid,Order order) throws NoSuchOrderFound{
		Optional<Order> order2 = repository.findById(orderid); 
		if(order2.isEmpty()) {
			throw new NoSuchOrderFound("No such order exist!");
		}else {
			repository.deleteById(orderid);
			repository.save(order);
			return "order Updated";
		}
		
	}

	@Override
	public String createOrder(Order order) throws  OrderWithIdAlreadyExist {
		Optional<Order> order2 = repository.findById(order.getOrderId()); 
		if(!order2.isEmpty()) {
			throw new OrderWithIdAlreadyExist("order with id "+order.getOrderId()+" is exist!");
		}
		repository.save(order);
		return (order.getOrderId()+" added");
	}

	@Override
	public String deleteOrder(int orderId) throws  NoSuchOrderFound {
		Optional<Order> order = repository.findById(orderId);
		if(order.isEmpty()) {
			throw new NoSuchOrderFound("No such order exist!");
		}else {
			repository.deleteById(orderId);
			
			return "order deleted";
		}
	}
}
