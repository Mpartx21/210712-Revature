package helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryProvider {
	public static SessionFactory sesh;
	
	public static SessionFactory getSesh()	{
		if(sesh == null) {
		sesh = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sesh;
	}

}
