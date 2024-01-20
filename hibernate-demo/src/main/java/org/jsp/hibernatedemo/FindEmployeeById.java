package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindEmployeeById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id to display details");
		int eid = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Employee e = s.get(Employee.class, eid);
		if (e != null) {
			System.out.println("Employee id: " + e.getId());
			System.out.println("Employee name: " + e.getName());
			System.out.println("Employee Number: " + e.getPhone());
			System.out.println("Desigation: " + e.getDesg());
			System.out.println("Salary :" + e.getSalary());
		} else {
			System.err.println("you have eneter an invalid id");
			sc.close();
		}
		

	}

}
