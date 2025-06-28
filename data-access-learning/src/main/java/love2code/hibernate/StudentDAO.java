package love2code.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import love2code.platform.transaction.manager.Student;

@Repository
public class StudentDAO {
	@Autowired
	private HibernateTransactionManager manager;
	@Autowired
	private SessionFactory factory;
	@Transactional
	public void addStudent(Student student) {
		factory.getCurrentSession().persist(student);
	}
	@Transactional
	public Student getStudent(int id) {
		Student stu=factory.getCurrentSession().get(Student.class, id);
		return stu;
		
	}
	
}
