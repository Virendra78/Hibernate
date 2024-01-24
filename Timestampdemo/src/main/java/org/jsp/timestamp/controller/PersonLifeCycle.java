package org.jsp.timestamp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.timestamp.dto.Person;

public class PersonLifeCycle {

	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Virat kohli");
		p.setPhone(987654321l);
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(p);
	transaction.begin();
	transaction.commit();
	
	p.setName("Rohit sharma");
	p.setPhone(8877665544l);
	transaction.begin();
	transaction.commit();
	
	p.setName("Ms Dhoni");
	p.setPhone(987654323l);
	transaction.begin();
	transaction.commit();
	
	manager.detach(p);
	p.setName("Lokesh Rahul");
	p.setPhone(888997766l);
	transaction.begin();
	transaction.commit();
	}

}
