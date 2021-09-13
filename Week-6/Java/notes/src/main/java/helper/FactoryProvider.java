package helper;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class FactoryProvider {
	public static SessionFactory sesh;
	
	public static SessionFactory getSesh()	{
		if(sesh == null) {
			sesh = new Configuration().configure("hibernate.")
		}
	}

}
