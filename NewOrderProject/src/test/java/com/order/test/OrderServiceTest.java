package com.order.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;


import com.order.exceptions.NoSuchOrderFound;
import com.order.exceptions.OrderWithIdAlreadyExist;
import com.order.model.Order;
import com.order.repository.OrdersRepository;
import com.order.service.OrderService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	OrdersRepository ordRepo;
	
	@Test
	void testFindOrderByIdShouldReturnOrderObject() throws NoSuchOrderFound,OrderWithIdAlreadyExist {
		Order order = new Order(104,LocalDate.of(2022, 06, 14),17, 900000);//testing employee
		ordRepo.save(order);
		Optional<Order> order2 = ordRepo.findById(104);
		
		boolean o = order2.isEmpty();
		assertEquals(false, o);
		}
	
	@Test
	void duplicateOrderShouldShowException() throws NoSuchOrderFound{
		assertThrows(OrderWithIdAlreadyExist.class, ()->{
			Order order = new Order(104,LocalDate.of(2022, 06, 14),17, 900000);
			ordRepo.save(order);
		});
	}

}
