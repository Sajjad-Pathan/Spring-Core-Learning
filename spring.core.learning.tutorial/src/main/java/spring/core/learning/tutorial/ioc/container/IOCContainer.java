package spring.core.learning.tutorial.ioc.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.learning.tutorial.pojo.Student;

public class IOCContainer {
/**
 * IOC Container, It is responsible to create,initialize,Manage,And destroy of bean
 * I.E IOC Container handle the object through its entire life cycle
 * IOC Container take meta data from xml or java configuration file to create object and for dependency injection
 * 
 * **/
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/core/learning/tutorial/ioc/container/BeanConfig.xml");
		System.out.println(context.getBean("firstStudent").toString());//we can access same object by toName beacause we have used alliase
		Student student=context.getBean("secondStudent",Student.class);
		System.out.println(student.toString());
		
		  
	}

}
