package org.jsp.timestamp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.springdemo.User;
import org.jsp.timestamp.dto.UserId;
public class Test {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		UserId userId=new UserId();
		userId.setEmail("xyz@gmail.com");
		userId.setPhone(987654381l);
		
		User u=new User();
		u.setUserId(userId);
		u.setName("ABC");
		u.setAge(23);
		manager.persist(u);
		transaction.begin();
		transaction.commit();
	}

}
