package org.jsp.timestamp.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.timestamp.dto.FoodOrder;
public class PlaceOdrer {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		FoodOrder order=new FoodOrder();
		order.setFood_item("Biryani");
		order.setCost(200);
		order.setLocation("jspider,102,BTM");
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(order);
		transaction.begin();
		transaction.commit();
	}

}
