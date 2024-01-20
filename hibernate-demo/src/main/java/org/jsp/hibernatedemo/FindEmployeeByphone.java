package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByphone {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Employee phone Number to Display detailsy");
		Long phone=sc.nextLong();
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q=s.createQuery("select e from Employee e where e.phone:ph");
		q.setParameter("ph",phone);
		try {
			Employee e=q.getSingleResult();
			System.out.println("Employee id:"+e.getId());
			System.out.println("Employee name:"+e.getName());
			System.out.println("Phone number:"+e.getPhone());
			System.out.println("Desigation:"+e.getDesg());
			System.out.println("salary:"+e.getSalary());
			System.out.println("-------------------");
		}
		catch(NoResultException e) {
			System.err.println("No Employee with phone number:"+phone);
		}
	}
}
