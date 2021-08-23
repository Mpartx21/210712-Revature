package com.revature.Utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	 private static final SessionFactory sessionFactory = buildSessionFactory();
     
	    private static SessionFactory buildSessionFactory() {
	        try{
	            // Create the SessionFactory from hibernate.cfg.xml
	            return new Configuration().configure(new File("hibernate.cgf.xml")).buildSessionFactory();
	        }
	        catch (Exception e) {
	            // Make sure you log the exception, as it might be swallowed
	            System.out.println("Initial SessionFactory creation failed." + e);
	        }
			return null;
	    }
	  
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	  
	    public static void shutdown() {
	        // Close caches and connection pools
	        getSessionFactory().close();
	    }

}
