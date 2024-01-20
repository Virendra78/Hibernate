package org.jsp.hibernatedemo;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DeleteEmployee {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the employee id to delete");
		int eid =sc.nextInt();
		Session s =new Configuration().configure().buildSessionFactory().openSession();
		Employee e=s.get(Employee.class,eid);
		if(e!=null) {
			s.delete(e);
			Transaction t=s.getTransaction();
			t.begin();
			t.commit();
			System.out.println("Employee deleted");
		}
		else {
			System.err.println("cannot be delete the employee as the id invalid");
		}
		sc.close();

	}

}
