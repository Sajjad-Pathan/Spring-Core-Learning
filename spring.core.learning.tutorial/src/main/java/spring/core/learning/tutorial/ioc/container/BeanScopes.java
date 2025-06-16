package spring.core.learning.tutorial.ioc.container;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.learning.tutorial.pojo.StudentAddress;
/**<bean class="spring.core.learning.tutorial.pojo.StudentAddress"
		id="singletonBean" name="singletonBean" scope="singleton"></bean>
		
		<bean class="spring.core.learning.tutorial.pojo.StudentAddress"
		id="prototypeBean" name="prototypeBean" scope="prototype"></bean>
		
	<bean id="myBean" name="myBean" class="spring.core.learning.tutorial.pojo.StudentAddress" scope="request"/>**/
public class BeanScopes {

	public static void main(String[] args) {
		//SingleTon Bean
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/core/learning/tutorial/ioc/container/BeanConfig.xml");
		StudentAddress firstObject=context.getBean("singletonBean",StudentAddress.class);
		StudentAddress secondObject=context.getBean("singletonBean",StudentAddress.class);
		if(firstObject==secondObject)
			System.out.println("Singleton Object");
		//Prototype Bean
		StudentAddress firstObjectPrototype=context.getBean("prototypeBean",StudentAddress.class);
		StudentAddress secondObjectPrototype=context.getBean("prototypeBean",StudentAddress.class);
		if(firstObjectPrototype!=secondObjectPrototype)
			System.out.println("Prototype Object");
		
	}

}
