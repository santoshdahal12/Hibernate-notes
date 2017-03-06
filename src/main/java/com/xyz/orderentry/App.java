package com.xyz.orderentry;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.xyz.controller.OrderController;
import com.xyz.domain.Item;
import com.xyz.domain.Order;
import com.xyz.repository.OrderRepository;
import com.xyz.service.OrderService;

/**
 * Hello world!
 *
 */
public class App 
{
	private static OrderRepository orderRepository= new OrderRepository();
	private static OrderService orderService= new OrderService(orderRepository);
	 private static OrderController orderController = new OrderController(orderService);
	 
	 
	
	 
	public static void main(String[] args) {
		//Entry for the user
		System.out.println("Order Creation");
		Item item1= new Item();
		item1.setName("Coke");
		item1.setPrice(12.00);
		Item item2= new Item();
		item2.setName("Coke");
		item2.setPrice(12.00);
		Order userOrder= new Order();
		
		userOrder.getItems().add(item1);
		userOrder.setTotalPrice(item1.getPrice());		
		
		userOrder.getItems().add(item2);
		userOrder.setTotalPrice(userOrder.getTotalPrice()+item2.getPrice());
		
		orderController.saveOrder(userOrder);
		System.out.println("................from database");
		List<Order> orders=orderController.getAllOrders();
		for(Order o: orders){
			System.out.println("...."+o.getId());
			System.out.println("...."+o.getTotalPrice());
			System.out.println("...."+o.getItems().toString());
			
		}
		
		
		
		/*emf.close();*/
	}
}
