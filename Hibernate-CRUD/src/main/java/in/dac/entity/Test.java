package in.dac.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test 
{
	public static void main(String a[]) {
		
		Student std = new Student();
		std.setName("ABC");
		std.setYearofpassing(2024);
		std.setBranch("CSE");
		
		Test t = new Test();
		//t.saveStudentDetails(std);	
		
		//t.getStudentDetailsById(2);
		
		//t.updateStudentDetails(1, 2020);
		
		t.deleteStudent(1);
		
	}
		
	public void saveStudentDetails(Student s) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tns = session.beginTransaction();		
		session.persist(s);		
		tns.commit();					
	}
	
	public void getStudentDetailsById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Student student = session.get(Student.class, id);
		System.out.println(student.toString());	
	}
	
	public void updateStudentDetails(int id, int yearofpassing) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tns = session.beginTransaction();
		
		Student student = session.get(Student.class, id);		
		student.setYearofpassing(yearofpassing);
		
		session.merge(student);
		tns.commit();	
	}
	
	public void deleteStudent(int id) {
		Transaction tns = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			tns = session.beginTransaction();
			
			Student student = session.get(Student.class, id);		
			session.remove(student);
			tns.commit();
		}catch(Exception ee){
			if(tns != null) {
				tns.rollback();
			}
		}
		
		
			
	}
	
}
