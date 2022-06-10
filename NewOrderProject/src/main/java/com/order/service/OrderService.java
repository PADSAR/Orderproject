package com.order.service;

import com.order.exceptions.NoSuchOrderFound;
import com.order.exceptions.OrderWithIdAlreadyExist;
import com.order.model.Order;

public interface OrderService {
	
	public Iterable<Order> getOrderList();
	public String updateOrder(int orderid,Order order) throws NoSuchOrderFound ;
	public String createOrder(Order order) throws OrderWithIdAlreadyExist;
	public String deleteOrder(int orderId) throws NoSuchOrderFound;
	

}
