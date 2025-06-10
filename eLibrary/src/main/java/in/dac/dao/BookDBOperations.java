package in.dac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.dac.entity.Address;
import in.dac.entity.Book;
import in.dac.entity.Student;
import in.dac.utils.HibernateUtil;

public class BookDBOperations {
SessionFactory sfactory;
	
	public BookDBOperations() {
		sfactory = HibernateUtil.getSessionFactory();
	}
	
	public void addBook(Book bk) {
		
		Transaction tns = null;
		Session session;
		try {
			session = sfactory.openSession();
			tns = session.beginTransaction();
			session.persist(bk);
			tns.commit();
			
		}catch(HibernateException he) {
			if(tns != null) {
				tns.rollback();
			}
			he.printStackTrace();
		}		
	}
	
	public Book getBookDetails(int bookid) {
		Book bk = null;
		try(Session session = sfactory.openSession()){
			bk = session.get(Book.class, bookid);
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		return bk;
	}
}
