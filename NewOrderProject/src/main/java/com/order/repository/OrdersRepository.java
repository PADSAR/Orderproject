package com.order.repository;

import com.order.model.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Integer>  {

}
