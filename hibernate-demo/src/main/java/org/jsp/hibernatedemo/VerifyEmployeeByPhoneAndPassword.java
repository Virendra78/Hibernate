package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByPhoneAndPassword {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Employee phone Number to Display detailsy");
		Long phone=sc.nextLong();
		String password=sc.next();
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q=s.createQuery("select e from Employee e where e.phone:?1 and e.password=?2");
		q.setParameter(1,phone);
		q.setParameter(2,password);
		try {
			Employee e=q.getSingleResult();
			System.out.println("verification sucessfull");
			System.out.println("Employee id:"+e.getId());
			System.out.println("Employee name:"+e.getName());
			System.out.println("phone number: "+e.getPhone());
			System.out.println("Desigation:"+e.getDesg());
			System.out.println("salary:"+e.getSalary());
			System.out.println("-------------------");
		}
		catch(NoResultException e) {
			System.err.println("Invalid phone number or password:");
		}
	}
}
