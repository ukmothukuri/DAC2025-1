package in.dac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructorDI {
	public static void main(String a[]) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		Student st = (Student) context.getBean("std");
		System.out.println(st.getName());
		Address ads = st.getAds();
		ads.displayAddress();
	}
}
