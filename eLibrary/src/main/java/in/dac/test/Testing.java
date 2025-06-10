package in.dac.test;

import in.dac.dao.AddressDBOperations;
import in.dac.dao.BookDBOperations;
import in.dac.dao.StudentDBOperations;
import in.dac.entity.Address;
import in.dac.entity.Book;
import in.dac.entity.Student;

public class Testing {

	public static void main(String a[]) {
		StudentDBOperations sdob = new StudentDBOperations();
		AddressDBOperations adob = new AddressDBOperations();
		BookDBOperations bdob = new BookDBOperations();
//		Student s =  new Student();
//		s.setName("Rajesh");
//		s.setEmail("rj@cdac.in");
//		s.setMobile("1234567890");
//		s.setBranch("CSE");
//		s.setYearofpassing(2021);
//		s.setPassword("dac@1234");
//		
//		Address ad = new Address();
//		ad.setFlat_house_no("101");
//		ad.setState("TG");
//		ad.setDistrict("RR");
//		ad.setPincode(500005);
//		ad.setCity("HYD");
//		adob.saveAddress(ad);
//		
//		s.setAddress(ad);
		
//		sdob.createStudent(s);
		
//		Book b1 = new Book();
//		b1.setName("Spring");
//		b1.setAuthor("Rod Johnson");
//		b1.setPrice(1050.00);
//		b1.setPublishedYear(1990);
//		
//		bdob.addBook(b1);
		
		Book b1 = bdob.getBookDetails(1);
		Book b2 = bdob.getBookDetails(2);
		Student st = sdob.getStudentDetails(5);
		st.getBooks().add(b1);
		st.getBooks().add(b2);
		sdob.updateStudentDetails(st);
	}
}
