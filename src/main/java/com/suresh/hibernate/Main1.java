/**
 * 
 */
package com.suresh.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.suresh.hibernate.model.Cat;
import com.suresh.hibernate.model.Dog;
import com.suresh.hibernate.model.Student;

/**
 * @author sresh
 *
 */
public class Main1 {

	/**
	 *for understanding the Criteria API which is equal to Where clause in SQL.
	 *for understanding the Criteria API with projections (Aggregate functions)-- for 
	 *retrieving the single column values using Porojecttions.property("id");
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//1.Criteria
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", 3))
				.add(Restrictions.eq("firstName", "pdspds"));
		 
		List<Student> list = (List<Student>)criteria.list();
		for (Student student : list) {
			System.out.println(student);
		}
		//2.Criteria
		Criteria criteria1 = session.createCriteria(Student.class);
		criteria1.add(Restrictions.or(Restrictions.like("firstName", "%d"), Restrictions.between("id", 1, 3)));
		List<Student> list1 = (List<Student>)criteria1.list();
		for (Student student : list1) {
			System.out.println(student);
		}
		
		//3.Criteria
		Criteria criteria2 = session.createCriteria(Student.class);
		criteria2.add(Restrictions.like("section", "%1"));
		List<Student> list6 = (List<Student>)criteria2.list();
		for(Student s: list6) {
			System.out.println("section ends with "  +s);
		}
		
		//understanding Projections
		
		//1.Projection
		Criteria criteriaProjection = session.createCriteria(Student.class)
				.setProjection(Projections.property("id"));//retireving one column all values
		List<Integer> list2 = (List<Integer>) criteriaProjection.list();
		System.out.println("Retrieving the single column values  using Projections.setProoperty" );
		System.out.println("id Projection "  +list2);
		
		//2.Projection
		Criteria criteriaProjection1 = session.createCriteria(Student.class)
				.setProjection(Projections.property("firstName"))
				.addOrder(Order.desc("firstName"));
		List<String> list3 = (List<String>) criteriaProjection1.list();
		System.out.println("firstName Projection in Desending Order " + list3);
		
		//3.Projection
		 Criteria setProjection = session.createCriteria(Student.class)
		  .setProjection(Projections.countDistinct("firstName")); 
		  List list4 = setProjection.list(); 
		  System.out.println("ProjectionList " +list4);
		 //4.projection
		  Criteria criteriaPro = session.createCriteria(Student.class)
				  .setProjection(Projections.property("id"))
				  .addOrder(Order.desc("id"));
		  
		  List list7 = criteriaPro.list();
		  System.out.println("ProjectionsList 7 " +list7);
		  
		  
		  //QueryByExamle understanding. (search on google for better understanding)
		  //instead of writing to many projections we can use QueryByExample
		  Student s = new Student();
		  //s.setFirstName("nsadhsd");
		  s.setId(3);
		  
		  Example ex = Example.create(s);
		  
		  Criteria add = session.createCriteria(Student.class).add(ex);
		  List list5 = add.list();
		  for (Object object : list5) {
			System.out.println(object);
		}
		  
		  
		  //practice one to Many mapping
			
			/*
			 * Cat cat = new Cat(); cat.setName("Cat-2"); Dog dog1 = new Dog();
			 * dog1.setName("Dog-3"); Dog dog2 = new Dog(); dog2.setName("Dog-4"); List<Dog>
			 * dogs = Arrays.asList(dog1,dog2); cat.setDogs(dogs); session.save(cat);
			 */
			 
			 
		    
		    //many to One mapping
			
			/*
			 * Cat cat1 = new Cat(); cat1.setName("Cat1-many-dogs"); Dog dogm1 = new Dog();
			 * dogm1.setName("Dog-many2-one"); dogm1.setCat(cat1);
			 * 
			 * Dog dogm2 = new Dog(); dogm2.setName("Dog-many2-two"); dogm2.setCat(cat1);
			 * 
			 * Dog dogm3 = new Dog(); dogm3.setName("Dog-many3-one"); dogm3.setCat(cat1);
			 * 
			 * session.save(dogm1); session.save(dogm2); session.save(dogm3);
			 * session.save(cat1);
			 */
			 
		  //many to many mapping 
		    
			/*
			 * Cat cat1 = new Cat(); cat1.setName("Cat-1"); Dog dog1 = new Dog();
			 * dog1.setName("Dog-1"); dog1.getCat().add(cat1); cat1.setName("Cat-1");
			 * cat1.getDogs().add(dog1);
			 * 
			 * Cat cat2 = new Cat(); cat2.setName("Cat-2"); Dog dog2 = new Dog();
			 * dog2.setName("Dog-2"); dog2.getCat().add(cat2); cat2.setName("Cat-2");
			 * cat2.getDogs().add(dog2);
			 * 
			 * session.save(cat1); session.save(cat2);
			 */
		
		tx.commit();
		session.close();
	}

}

//Criteria is Simplified API for retrieving the entites by composing of Criterion objects.

//You may specify projection and aggregation using Projection instances obtained via the factory methods on Projections.