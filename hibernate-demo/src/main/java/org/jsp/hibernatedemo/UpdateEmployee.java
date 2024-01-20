package org.jsp.hibernatedemo;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id to update details:");
		int eid=sc.nextInt();
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Employee e=s.get(Employee.class, eid);
		if(e!=null) {
			System.out.println("Employee the name,phone,desigation,salaryand password");
			e.setName(sc.next());
			e.setPhone(sc.nextLong());
			e.setDesg(sc.next());
			e.setSalary(sc.nextInt());
			e.setPassword(sc.next());
			Transaction t=s.beginTransaction();
			t.commit();
			
		}
		else {
			System.err.println("cannot update as the entered id is invalid");
		}
		sc.close();
	}
	

}
