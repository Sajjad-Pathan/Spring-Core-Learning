package love2code.low.level.approach;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataSourceUtilsApp {

	public static void main(String[] args) {
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
			DAOLayer daoLayer=context.getBean(DAOLayer.class);
			daoLayer.addStudent();
			daoLayer.getStudent();

	}

}
