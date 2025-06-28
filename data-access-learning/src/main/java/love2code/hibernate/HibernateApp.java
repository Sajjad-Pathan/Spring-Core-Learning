package love2code.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import love2code.platform.transaction.manager.Student;

@Component
public class HibernateApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
		HibernateService hibernateService=context.getBean(HibernateService.class);
		hibernateService.addStudent(new Student(786,"Sajjad Pathan","9699173489"));
		hibernateService.getStudent(786);
	}
}
