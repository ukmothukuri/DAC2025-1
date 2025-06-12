package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         Resource resource=new ClassPathResource("applicationContext.xml");  
         BeanFactory factory=new XmlBeanFactory(resource);  

         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         Student bean = context.getBean("std", Student.class);
         bean.setName("Uday K");
         bean.setEmail("uday@cdac.in");

         StudentDAO sdao = context.getBean(StudentDAO.class);
         sdao.saveStudent(bean);
    }
}
