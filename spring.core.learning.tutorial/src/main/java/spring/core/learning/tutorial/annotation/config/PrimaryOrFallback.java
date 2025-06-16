package spring.core.learning.tutorial.annotation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Fallback;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Configuration
public class PrimaryOrFallback {
	
	@Bean
	@Primary
	public Student myStudent() {
		return new Student(" ", " ");
		
	}
	
	@Bean
	@Fallback
	public Student myStudent2() {
		return new Student("  ", " ");
		
	}
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/core/learning/tutorial/annotation/config/AnnotationConfig.xml");
		Student student=context.getBean(Student.class);
		System.out.println(student.hashCode());
	}

}
