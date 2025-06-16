package spring.core.learning.tutorial.ioc.container;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.learning.tutorial.pojo.StudentAddress;

/**
 * <bean id="myBean" class="com.example.MyBean"> <property name="mySet"> <set>
 * <value>Red</value> <value>Green</value> <value>Blue</value> </set>
 * </property> </bean>
 *
 * 
 * <bean id="myBean" class="com.example.MyBean"> <property name="myMap"> <map>
 * <entry key="name" value="John"/> <entry key="age" value="30"/>
 * <entry key="city" value="New York"/> </map> </property> </bean>
 * 
 * <bean id="myBean" class="com.example.MyBean"> <property name="myList"> <list>
 * <value>Apple</value> <value>Banana</value> <value>Cherry</value> </list>
 * </property> </bean>
 */
public class CollectionByContainer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/core/learning/tutorial/ioc/container/BeanConfig.xml");
		StudentAddress myNorth = context.getBean("MyNorth", StudentAddress.class);
		myNorth.getList().forEach(System.out::println);

	}

}
