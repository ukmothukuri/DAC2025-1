package in.dac.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sfactory;
	
	public static SessionFactory getSessionFactory() {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");	
		sfactory = config.buildSessionFactory();
		
		return sfactory;
	}
}
