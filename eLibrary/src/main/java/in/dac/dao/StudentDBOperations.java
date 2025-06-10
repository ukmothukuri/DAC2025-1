package in.dac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.dac.entity.Student;
import in.dac.utils.HibernateUtil;

public class StudentDBOperations {
	
	SessionFactory sfactory;
	
	public StudentDBOperations() {
		sfactory = HibernateUtil.getSessionFactory();
	}
	
	public int createStudent(Student s) {
		int rollnumber = 0;
		Transaction tns = null;
		Session session;
		try {
			session = sfactory.openSession();
			tns = session.beginTransaction();
			session.persist(s);
			tns.commit();		
			System.out.println("Student Roll Number "+s.toString());
			rollnumber = s.getId();
		}catch(HibernateException he) {
			if(tns != null) {
				tns.rollback();
			}
			he.printStackTrace();
		}
		return rollnumber;
	}
	
	public Student getStudentDetails(int rollnumber) {
		Student std = null;
		try(Session session = sfactory.openSession()){
			std = session.get(Student.class, rollnumber);
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		return std;
	}
	
	public void updateStudentDetails(Student std) {
		Session session;
		Transaction tns = null;
		try {
			session = sfactory.openSession();
			tns = session.beginTransaction();
			session.merge(std);
			tns.commit();
			
		}catch(HibernateException he) {
			if(tns != null) {
				tns.rollback();
			}
			he.printStackTrace();
		}
	}
	
	public void deleteStudentDetails() {
		
	}
}

	