package in.dac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.dac.entity.Address;
import in.dac.entity.Student;
import in.dac.utils.HibernateUtil;

public class AddressDBOperations {
SessionFactory sfactory;
	
	public AddressDBOperations() {
		sfactory = HibernateUtil.getSessionFactory();
	}
	
	public void saveAddress(Address ads) {
		
		Transaction tns = null;
		Session session;
		try {
			session = sfactory.openSession();
			tns = session.beginTransaction();
			session.persist(ads);
			tns.commit();
			
		}catch(HibernateException he) {
			if(tns != null) {
				tns.rollback();
			}
			he.printStackTrace();
		}
		
	}
}
