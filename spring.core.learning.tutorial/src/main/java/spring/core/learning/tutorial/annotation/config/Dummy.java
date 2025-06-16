package spring.core.learning.tutorial.annotation.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/core/learning/tutorial/annotation/config/AnnotationConfig.xml");
		Student student=context.getBean(Student.class);
		System.out.println(student.hashCode());
	
	}

}
