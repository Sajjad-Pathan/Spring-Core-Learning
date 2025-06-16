package spring.core.learning.tutorial.ioc.container;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjection {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/core/learning/tutorial/ioc/container/BeanConfig.xml");
		System.out.println("By Using Constructor");
		System.out.println(context.getBean("thirdStudent").toString());
		System.out.println("By Using Setter");
		System.out.println(context.getBean("bySetter").toString());
		
	}

}
