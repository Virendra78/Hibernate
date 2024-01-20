package org.jsp.hibernatedemo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee2 {
	public static void main(String[]args) {
		Employee e=new Employee();
		e.setId(5);
		e.setName("Bahuballi");
		e.setPhone(9894656375l);
		e.setDesg("JavaDeveloper");
		e.setSalary(35000);
		e.setPassword("Devasena");
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		s.saveOrUpdate(e);
		Transaction t=s.beginTransaction();
		t.commit();
	}
}
