package org.jsp.timestamp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jsp.springdemo.User;
import org.jsp.timestamp.dto.UserId;

public class FindUserByPrimaryKey {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		UserId userId=new UserId();
		userId.setEmail("xyz@gmail.com");
		userId.setPhone(9876543210l);
		User u=manager.find(User.class,userId);
		if(u!=null) {
			System.out.println("User Name:"+u.getName());
			System.out.println("Age: "+u.getAge());
			System.out.println("phone number"+u.getUserId().getPhone());
			System.out.println("Email id:"+u.getUserId().getEmail());
		}
		else {
			System.err.println("Invalid phone number or email");
		}

	}

}
