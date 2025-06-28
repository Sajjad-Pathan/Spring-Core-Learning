package love2code.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import love2code.platform.transaction.manager.Student;
@Service
public class HibernateService {
	  @Autowired
	    private StudentDAO dao;

	    @Transactional
	    public void addStudent(Student student) {
	        dao.addStudent(student);
	    }

	    @Transactional(readOnly = true)
	    public void getStudent(int id) {
	        Student student = dao.getStudent(id);
	        System.out.println(student);
	    }
}
