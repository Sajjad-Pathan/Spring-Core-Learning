package spring.core.learning.tutorial.annotation.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
/**@PostConstruct
	public void postInit() {
		System.out.println("@PreConstruct");
	}
	
	public void inBetween() {
		System.out.println("Studying.....");
	}
	
	@PreDestroy
	public void preDelete() {
		System.out.println("@PreDestroy");
	}
	
	@PreConstruct
    Studying.....
	@PreDestroy
	**/
public class PreConstructAndPostDestroy {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/core/learning/tutorial/annotation/config/AnnotationConfig.xml");
		Student student=context.getBean(Student.class);
		student.inBetween();
		context.close();
	}

}
