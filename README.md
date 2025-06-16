# Spring-Core-Learning
Just wrapped up a hands-on learning project diving deep into Spring Core! Covered essentials like IoC Container, Dependency Injection, Bean Scopes, Autowiring, Lazy Initialization, Annotation &amp; Java-based Config, and Environment Abstraction. A solid foundation for mastering enterprise-grade Java apps with Spring Framework!






This is learning project in which we are going to apply all concepts related to Spring Core Like IOC Container, Dependency, Dependency Injection, Bean Scope, 
Lazy Initialization, Autowiring, Annotation based container Configuration, ClassPath Scanning,BeanFactory, ApplicationContext, Data Bonding, Type Conversion, Validation
Spring Expression language and more.

This Project will state in depth explaination and configuration of above features of spring core along with the practical knowledge.

1) IOC Container:-	
	*Introduction to the Spring IoC Container and Beans:-The org.springframework.beans and org.springframework.context packages are the basis for Spring Framework’s IoC container. 
				The BeanFactory interface provides an advanced configuration mechanism capable of managing any type of object. 
				ApplicationContext is a sub-interface of BeanFactory.
				A bean is an object that is instantiated, assembled, and managed by a Spring IoC container.

    *Container Overview:- The container is responsible to assembling,configuration And instantiating Bean And Container take help to create this beans from XML,Java Annotation ...
    	XML or Annotation contains the meta data for which bean and how to create bean dependant object like this meta data.
    	"BeanFactory And ApplicationContext these interface represent the IOC Container "
    	ApplicationContext Has further 2 implementations AnnotationConfigApplicationContext And ClassPathXmlApplicationContext
    	
    	If we create XML Meta data file then we need to add ;--> 
    	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
		https://www.springframework.org/schema/beans/spring-beans.xsd">
    	this xmlns in our XMl file
    	
    	To Import XMl file in other Xml File Or to create central xml configuration
		    <import resource="services.xml"/>
			<import resource="resources/messageSource.xml"/>
			<import resource="/resources/themeSource.xml"/>
    	
	
	
	*Bean Overview:- The Spring IOC Container manage one or more beans which is created by meta data, the data we provide to container through XML file or java annotation
							While accesing applicationcontext spring recommend to use fully path. 
							You can always use fully qualified resource locations instead of relative paths: for example,
							 file:C:/config/services.xml or classpath:/config/services.xml. or config file is in same directory then it will work like
							 ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/core/learning/tutorial/ioc/container/BeanConfig.xml");
							
							alias--> we can set bean name outside the bean definition by using alias.
							 for Example <alias name="firstStudent" alias="toName"/>{firstStudent also will be known as toName}
							 
	*Dependencies:- the simplest application has a few objects that work together to present users need.
						in simply we can say that object A depend on object B while instantiating.
						Independent Student object depend on independent Address object;
						Dependency Injection: DI exists in two major variants: Constructor-based dependency injection and Setter-based dependency injection.
						with Setter based injection there must be the setter and getter methods in pojo and one default constructor is require
						
						
						ref--> The ref element is the final element inside a <constructor-arg/> or <property/> definition element. 
						Here, you set the value of the specified property of a bean to be a reference to another bean managed by the container.
						<ref bean="anotherExampleBean"/>  we add dependent Object by using ref attribute
						
						P schema instead of writing property every time we can create p schema 
						xmlns:p="http://www.springframework.org/schema/p"
						<property name="driverClassName" value="com.mysql.jdbc.Driver"/> VS p:driverClassName="com.mysql.jdbc.Driver"
						
						
						collections-->> we can also inject or create collection using container there are some tags provided by Sprin
						The <list/>, <set/>, <map/>, and <props/> 
						
					Using depends-on---> when one object depend on other and dependent object is not created bu ioc then it cause an error 
					to overcome this problem we have depends-on or @DependsOn 
					in simple words- “Hey, before you create this bean, please make sure this other one is created first.”
							<bean class="spring.core.learning.tutorial.pojo.Student"
							id="thirdStudent" depends-on="thirdStudentAdd">
							<constructor-arg value=" Pathan" name="name"></constructor-arg>
							<constructor-arg value="Sajjadpathan@gmail.com" name="email"></constructor-arg>
							<constructor-arg ref="thirdStudentAdd" name="address"></constructor-arg>
						</bean>
					
				Lazy-initialized Beans--By deafault spring initialize all instance at the time of stating project and it happens that unused instance get
				created so to overcome this we use lazy initialization so instance will create when its require
				
				This behavior is controlled by the @Lazy annotation or in XML the lazy-init attribute on the <bean/> element
				<bean name="bySetter" id="bySetter" class="spring.core.learning.tutorial.pojo.Student" lazy-init="true">
				
						Autowiring Collaborators:- “Let Spring automatically find and connect the right object (bean) for me.”
								When a object need another object i.e DI spring automatically find that bean for you and inject it
						it follows following ways to inject object;
									By Type (most common): Match by class type.
									By Name: Match by bean name (used more in XML config).
									Constructor / Setter: Autowire through constructors or setters
	
	
	  *Bean Scopes
						  Table 1. Bean scopes
					Scope								Description
					singleton								(Default) Scopes a single bean definition to a single object instance for each Spring IoC container.
					
					prototype								Scopes a single bean definition to any number of object instances.
					
					reques     								 Scopes a single bean definition to the lifecycle of a single HTTP request. That is,
															 each HTTP request has its own instance of a bean created off the back of a single bean definition.
															  Only valid in the context of a web-aware Spring ApplicationContext.
					There are more scopes of bean available on spring documentation

	*Customizing the Nature of a Bean  -->  we use preInitialisation or post to initialise or destroy resources
	
						these 3 approaches we can use:
												The InitializingBean and DisposableBean callback interfaces
												Custom init() and destroy() methods
												The @PostConstruct and @PreDestroy annotations
	
	
	
	Annotation-based Container Configuration:- with the help of annotation we skip all the manual configuration Spring do automatic confiuration for us
To Make this annotation readable for spring we need to add this in our xml file
And it only work with same ApplicationContext so we need to add this xmlns and context tag in every xml file which contain meta data for container
		http://www.springframework.org/schema/context
		https://www.springframework.org/schema/context/spring-context.xsd">
		<context:annotation-config/>
some time we get error called no bean definition available in container then add component scan in xml
<context:component-scan base-package="spring.core.learning.tutorial"></context:component-scan>
@Component	Marks a class as a Spring-managed component
@Service	Specialization of @Component for service layer classes.
@Repository	Specialization of @Component for persistence/DAO classes.
@Controller	Specialization of @Component for MVC controllers.
@RestController	Combines @Controller and @ResponseBody for REST APIs.
@Bean	Declares a bean in a Java @Configuration class.
@Configuration	Marks a class as a configuration class (replaces XML).
@ComponentScan	Tells Spring to scan the package for components.
@Import	Allows importing other configuration classes.
@PropertySource	Loads properties file into Spring Environment.
@Autowired	Automatically injects dependencies by type.
@Qualifier	Helps choose the right bean when multiple matches are found.
@Inject	Java standard (JSR-330) alternative to @Autowired.
@Resource	Java standard (JSR-250), injects by name by default.
@Value	Injects primitive values or properties from a config file.
Annotation	Purpose
@PostConstruct	Method called after bean initialization.
@PreDestroy	Method called before bean destruction.
Annotation	Purpose
@Scope	Defines the scope of a bean (singleton, prototype, request, session, etc.).
@Lazy	Bean will be created only when needed, not at startup.
@DependsOn	Specifies that one bean must be initialized before another.
@Primary	Marks a bean as the default choice when multiple candidates exist.

Annotation-based Autowiring with @Primary or @Fallback-->  when we have multiple bean definition at the time container get confused which 
object to inject so to ignore this we use  @Primary and if we add @Fallback then the non Fallback object will inject
error without Primary or Fallback --> expected single matching bean but found 3: student,myStudent,myStudent2

@Value is typically used to inject external properties or values the valus we are declare in application.properties:




*Classpath Scanning and Managed Components:
  In previous we see the behaviour of container depends on the bean definition i.e we need to give meta date to container to create bean
  but using Componenet Scan the container automatic detect Component and make it available for container to create bean
  
	Using JSR 330 Standard Annotations:-- it is nothing but an alternate approach for DI lile for @Component they have @jakarta.inject.Named or jakarta.annotation.ManagedBean
	we can use it like 		@Named("movieListener")  // @ManagedBean("movieListener") could be used as well
							public class SimpleMovieLister {
							
							
							
	*Java-based Container Configuration:
							Section Summary:-This annotation used in your Java code to configure the Spring container.
							
							
							Basic Concepts: @Bean and @Configuration
							
							@Bean: The @Bean annotation is used to indicate that a method instantiates, configures, and initializes 
							a new object to be managed by the Spring IoC container.
							we create @Bean method in A class annotated with @Configuration.
							
							@Configuration
							public class AppConfig {
							
								@Bean
								public MyServiceImpl myService() {
									return new MyServiceImpl();
								}
							}
							
		*Instantiating the Spring Container by Using AnnotationConfigApplicationContext:--  with the use of AnnotationConfigApplicationContext
		we don't need to create xml file we create a java class annotate with @Confiuration and create beans method using @Bean and 
		then use AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class) to create container
		and so how we get our beans
		AnnotationConfigApplicationContext provide some methods to get that bean
		
		
		
							Using the @Bean Annotation:- @Bean is a method level annotation which is used to create or to provide metadata to container 
							it has some attributes like Autowire, init-method, destroy-method,autowiring name. or @Scope, @PreDestroy, @PostCreate
							@Autowire
							
		* Using the @Configuration annotation
								@Configuration is a class-level annotation indicating that an object is a source of bean definitions.
							
							Composing Java-based Configurations@Configuration classes declare beans through @Bean-annotated methods. 
							Calls to @Bean methods on @Configuration classes can also be used to define inter-bean dependencies
							
							we can also import Configuration class into other Config class like @Import(ConfigA.class) over the class
							so the beans in both class can be access by container 
							suppose A Config class import in B then container of B can have beans in A And B 
							@Import({A.class, B.class})
							@Configuration
							public class C{}
							
	* Environment Abstraction: Enviroment Interface used to create diffrent configuration for diffrent phases, @Profile annotation used make 
	Enviroment specific configuration
	
