package spring.core.learning.tutorial.ioc.container;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.learning.tutorial.pojo.Student;

public class AutowireByContainer {
/**<bean class="spring.core.learning.tutorial.pojo.Student"
		id="thirdStudent" depends-on="thirdStudentAdd">
		<constructor-arg value=" Pathan" name="name"></constructor-arg>
		<constructor-arg value="Sajjadpathan@gmail.com" name="email"></constructor-arg>
		<constructor-arg ref="autowireCandidate" name="address"></constructor-arg>
	</bean>
	
		<bean class="spring.core.learning.tutorial.pojo.StudentAddress"
		id="autowireCandidate" autowire-candidate="true" lazy-init="true"/>	**/
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/core/learning/tutorial/ioc/container/BeanConfig.xml");
		Student student=context.getBean("autoStudent",Student.class);
			System.out.println(student.toString());
	}

}
