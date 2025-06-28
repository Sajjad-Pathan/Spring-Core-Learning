package love2code.platform.transaction.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlatformManagerDataSourceApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  context=new AnnotationConfigApplicationContext(BeanConfig.class);
		DAOLayer daoLayer=context.getBean(DAOLayer.class);
		daoLayer.addStudent();
		context.close();

	}

}
