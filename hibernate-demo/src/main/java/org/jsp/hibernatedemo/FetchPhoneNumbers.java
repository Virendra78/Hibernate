package org.jsp.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhoneNumbers {

	public static void main(String[] args) {
		String qry="seelct e.phone from Employee:";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Long> q=s.createQuery(qry);
		List<Long>phones=q.getResultList();
		for(long phone:phones) {
			System.out.println("phone");
		}

	}

}
