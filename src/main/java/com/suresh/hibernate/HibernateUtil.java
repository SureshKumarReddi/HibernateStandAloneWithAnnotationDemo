package com.suresh.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() throws InstantiationException {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(config.getProperties());

		StandardServiceRegistry registry = sb.build();

		SessionFactory sessionFactory = config.buildSessionFactory(registry);

		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	public static void shutDown() {
		getSessionFactory().close();
	}
}

/*
   static{ final StandardServiceRegistry registry = new
   StandardServiceRegistryBuilder() .configure() // configures settings from
   hibernate.cfg.xml .build(); try { sessionFactory = new
   MetadataSources(registry).buildMetadata().buildSessionFactory(); } catch
   (Exception ex) { StandardServiceRegistryBuilder.destroy(registry); } }
   
 */