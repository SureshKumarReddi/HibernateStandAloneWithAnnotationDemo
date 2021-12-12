package com.suresh.hibernate;
/*
 * package com.websystique.hibernate;
 * 
 * import java.util.ArrayList; import java.util.HashSet; import java.util.List;
 * import java.util.Set;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.Transaction;
 * 
 * import com.websystique.hibernate.model.Address; import
 * com.websystique.hibernate.model.Bank; import
 * com.websystique.hibernate.model.Customer; import
 * com.websystique.hibernate.model.Employee;
 * 
 * public class HibernateStandAloneDemo {
 * 
 * public static void main(String[] args) throws InstantiationException {
 * 
 * System.out.println("inside maain thread");
 * 
 * //test data used for one to many <-> relation
 * 
 * // Employee emp = new Employee(); // emp.setName("Suresh"); //
 * emp.setSalary(123.345); // // Address address1 = new Address(); //
 * address1.setStreet_Name("MRP"); // address1.setCity("HUP"); //
 * address1.setEmployee(emp); // // Address address2 = new Address(); //
 * address2.setStreet_Name("CRP"); // address2.setCity("HDP"); //
 * address2.setEmployee(emp); // List<Address> list = new ArrayList<Address>();
 * // list.add(address1); // list.add(address2); //
 * System.out.println("Address is " +address1); //
 * System.out.println("Address is " +address2); // //
 * emp.getAddress().addAll(list);
 * 
 * 
 * //one to one mapping Demo
 * 
 * // Address address = new Address(); // address.setStreet_Name("MRP"); //
 * address.setCity("HUP"); // // Employee emp = new Employee(); //
 * emp.setName("Suresh"); // emp.setSalary(123.345); // emp.setAddress(address);
 * 
 * //one to many and many to one relationship
 * 
 * // System.out.println("creating session factory"); // SessionFactory
 * sessionFactory = HibernateUtil.buildSessionFactory(); // Session session =
 * sessionFactory.openSession(); // Transaction tx = session.beginTransaction();
 * // // session.save(emp); // tx.commit(); // session.close();
 * 
 * 
 * //Many to Many Mapping relationship
 * 
 * 
 * //bank test data Bank bank1 = new Bank(); bank1.setName("SBI");
 * bank1.setBranchName("Hindupur");
 * 
 * Customer customer1 = new Customer(); customer1.setCustomerName("Suresh");
 * customer1.setEmailId("Sureshy@hcl.com"); customer1.setMobileNo(1234456789);
 * 
 * Customer customer2 = new Customer(); customer2.setCustomerName("Naresh");
 * customer2.setEmailId("Nareshy@hcl.com"); customer2.setMobileNo(534456789);
 * 
 * Set<Customer> customers = new HashSet<Customer>(); customers.add(customer1);
 * customers.add(customer2);
 * 
 * bank1.setCustomers(customers);
 * 
 * //customerentity test data Customer customer = new Customer();
 * customer.setCustomerName("Harish"); customer.setEmailId("Harish@hcl.com");
 * customer.setMobileNo(12456778);
 * 
 * Bank bank2 = new Bank(); bank2.setName("HDFC");
 * bank2.setBranchName("Hyderabad");
 * 
 * Bank bank3 = new Bank(); bank3.setName("Axis");
 * bank3.setBranchName("Hyderabad");
 * 
 * Set<Bank> banks = new HashSet<Bank>(); banks.add(bank2); banks.add(bank3);
 * 
 * 
 * System.out.println("creating session factory"); SessionFactory sessionFactory
 * = HibernateUtil.buildSessionFactory(); Session session =
 * sessionFactory.openSession(); Transaction tx = session.beginTransaction();
 * 
 * session.save(bank1); tx.commit(); session.close();
 * 
 * } }
 */