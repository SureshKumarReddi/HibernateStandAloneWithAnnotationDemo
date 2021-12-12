package com.suresh.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.suresh.hibernate.model.Student;

public class Main {

	public static void main(String[] args) throws InstantiationException {
		/*
		 * Student s1 = new Student(); s1.setFirstName("pdspds"); s1.setLastName("sds");
		 * s1.setSection("s1\2");
		 * 
		 * Student s2 = new Student(); s2.setFirstName("nsadhsd");
		 * s2.setLastName("psds"); s2.setSection("s4");
		 */
		
	 
		 SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 System.out.println("Now we are understnding the HQL operations ");
//1		 //Query query = session.createQuery("from Student where id>2");
//		 Query query = session.createQuery("from Student");
//		 List<Student> list = (List<Student>)query.list();
//		
//		 
//		 System.out.println(list + " \n" +list.size());
		 
			/*2.
			 * System.out.println("Iterating over the list"); for(Iterator<Student> iterator
			 * = list.iterator(); iterator.hasNext();) { Student student = (Student)
			 * iterator.next(); System.out.println(student); } System.out.println();
			 * System.out.println("Pagination using HQL how many records to be displayed");
			 * 
			 * 
			 * query.setFirstResult(1); //starts result from the second row.
			 * query.setMaxResults(2); //end results with 2 records(2+2) List<Student> list2
			 * = (List<Student>)query.list();
			 * 
			 * System.out.println("Iterating over the list"); for(Iterator<Student> iterator
			 * = list2.iterator(); iterator.hasNext();) { Student student = (Student)
			 * iterator.next(); System.out.println(student.getFirstName() +" "
			 * +student.getLastName()); }
			 */ 
		
			/*
			 * //3. retrieving two columns from the Class
			 *  
			 *  Query query = session.createQuery("select  min(id),max(id) from Student"); Query query =
			 * session.createQuery("select  firstName,lastName from Student"); List list =
			 * query.list();
			 * 
			 * Iterator iter = list.iterator(); while(iter.hasNext()) { Object[] result =
			 * (Object[])iter.next(); System.out.println(result[0] +" " +result[1]); }
			 */
		 
			/*
			 * //4.parameter binding int id = 2; //1. Appending Parameters(id is appending to query) one way which may
			 * cause SQL Injection
			 * 
			 * //Query query = session.createQuery("from Student where id >  " +id);
			 * 
			 * //second way which uses named Parameters (Positioned Parameter , here we are
			 * specifying the Position). //Query query =
			 * session.createQuery("from Student where id > ? "); //query.setInteger(0, id);
			 * 
			 * //alternate to second way which uses place holders Query query =
			 * session.createQuery("from Student where id > :studId ");
			 * query.setInteger("studId", id);//place id under studId in the query
			 * 
			 * List<Student> list = (List<Student>)query.list(); for (Student student :
			 * list) { System.out.println(student); }
			 * 
			 */
		 
		  //5.NamedQueries and NamedNativeQuery demo
		 
		 	//create both queries at entity level(go to entity class)
		 	int id = 2;  
		 	//once namedQuery created at entity level ,just call that query by using below method)
			/*
			 * Query query = session.getNamedQuery("namedQueryById"); query.setInteger(0,
			 * id);
			 */
		 	
		 	//advantage of getNamedQuery() allows to execute sql queries also . for this create NamedNativeQuery
		 	//at method level
		 	Query query = session.getNamedQuery("namedNativeQueryById"); 
		 	query.setInteger(0, id);
		 	
		  List list = query.list();
		 	 for (Object object : list) {
				System.out.println(object);
			}
		 	
		 tx.commit();
		 session.close();
	}

}

