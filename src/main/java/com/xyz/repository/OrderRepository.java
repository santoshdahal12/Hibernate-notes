package com.xyz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.xyz.domain.Order;
import com.xyz.orderentry.JPAUtils;

public class OrderRepository {
	
	public OrderRepository(){
		
	}
	public void saveOrder(Order userOrder) {

		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(userOrder);
			tx.commit();

		}

		catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
		/*em.close();*/

	}
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Query query= em.createQuery(" from userOrder");
			System.out.println();
			List<Order> orders= query.getResultList();
			System.out.println(orders.size()+"..........in repo");
			tx.commit();
			return orders;
			

		}

		catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
			
		}
		
		return null;
	}

}
