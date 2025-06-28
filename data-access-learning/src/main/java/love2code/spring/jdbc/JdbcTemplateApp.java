package love2code.spring.jdbc;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import love2code.platform.transaction.manager.Student;

@Repository
public class JdbcTemplateApp {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addStudent() {
		int num=jdbcTemplate.update("insert into studentdatabase values(426,'Mary Marx','2323939494')");
		Student student=jdbcTemplate.queryForObject("select *from studentdatabase where id=456",(ResultSet set,int row)->{
			return new Student(set.getInt(1),set.getString(2),set.getString(3));
		});
		
		System.out.println(student.toString());
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(BeanConfig.class);
		JdbcTemplateApp app2=app.getBean(JdbcTemplateApp.class);
		
		app2.addStudent();
	}

}
