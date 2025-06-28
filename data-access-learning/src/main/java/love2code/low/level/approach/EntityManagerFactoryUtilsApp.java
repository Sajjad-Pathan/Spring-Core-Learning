package love2code.low.level.approach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Repository;

import love2code.platform.transaction.manager.Student;

@Repository
public class EntityManagerFactoryUtilsApp {
	
	private javax.persistence.EntityManagerFactory factory;
	
	public void addStudent() {
		javax.persistence.EntityManager m=EntityManagerFactoryUtils.getTransactionalEntityManager(factory);
		
		m.persist(new Student(123,"John","898298989"));
		Student s=m.find(Student.class,123);
		System.out.println(s.toString());
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Bean.class);
		EntityManagerFactoryUtilsApp app=context.getBean(EntityManagerFactoryUtilsApp.class);
		app.addStudent();
		
	}

}
