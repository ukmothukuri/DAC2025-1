package in.dac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanScope {
	
	public static void main(String a[]) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring-beans.xml");

		Student st1 = (Student)context.getBean("std");
		System.out.println(st1);
		Student st2 = (Student)context.getBean("std");
		System.out.println(st2);
	}

	
}
