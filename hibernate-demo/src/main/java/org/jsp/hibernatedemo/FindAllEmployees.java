package org.jsp.hibernatedemo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FindAllEmployees {
	public static void main(String[] args) {
		String hql="Select emp from Employee emp";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q=s.createQuery(hql);
		List<Employee> emps=q.getResultList();
		for(Employee e:emps) {
			System.out.println("Employee id:"+e.getId());
			System.out.println("Employee name:"+e.getName());
			System.out.println("Phone number:"+e.getPhone());
			System.out.println("Desigation:"+e.getDesg());
			System.out.println("salary:"+e.getSalary());
			System.out.println("-------------------");
		}

	}

}
