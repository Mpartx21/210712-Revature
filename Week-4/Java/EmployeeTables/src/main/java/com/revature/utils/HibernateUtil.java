package com.revature.utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	 private static final SessionFactory sessionFactory = buildSessionFactory();
     
	    private static SessionFactory buildSessionFactory() {
	        try{
	        	Configuration cfg = new Configuration();
	            
	            // read the configuration and load in the object
	            cfg.configure("hibernate.cfg.xml");
	            
	            // create factory
	            SessionFactory factory = cfg.buildSessionFactory();
	            
	            return factory;
	        	
	        }catch (Exception e) {
	            // Make sure you log the exception, as it might be swallowed
	        	 System.err.println("Initial SessionFactory creation failed." + e);
	             throw new ExceptionInInitializerError(e);
	        }
	    }
	  
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	  
	    public static void shutdown() {
	        // Close caches and connection pools
	        getSessionFactory().close();
	    }

}
