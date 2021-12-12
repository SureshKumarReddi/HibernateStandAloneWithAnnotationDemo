package com.suresh.hibernate.Inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.suresh.hibernate.HibernateUtil;

public class Main1 {

	public static void main(String[] args) throws InstantiationException {
		
		 SessionFactory factory = HibernateUtil.buildSessionFactory();
			Session session =  factory.openSession();
			Transaction tx = session.beginTransaction();
			
			Vehicle vehicle = new Vehicle();
			vehicle.setName("Design-Vehicle");
			
			TwoWheeler t2 = new TwoWheeler();
			t2.setName("Bike");
			t2.setSteeringType("handle");
			
			FourWheeler f4 = new FourWheeler();
			f4.setName("Honda-Amaze");
			f4.setSteeringType("wheel");
			
			
			session.save(vehicle);
			session.save(t2);
			session.save(f4);
			
			tx.commit();
			session.close();
			

			
	}

}
