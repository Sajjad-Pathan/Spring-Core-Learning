package love2code.spring.jdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
@Repository
public class SimpleJDBCInsertApp {
	private SimpleJdbcInsert insert;
	
	
	@Autowired
	public SimpleJDBCInsertApp(DataSource dataSource) {
		this.insert=new SimpleJdbcInsert( dataSource).withTableName("studentdatabase");
	}

	@Transactional
	public void addStudent() {
		Map<String,Object> parameter=new HashMap<String, Object>();
		parameter.put("id", 347);
		parameter.put("name", "John arryn");
		parameter.put("number", "2382323232");
		int n=insert.execute(parameter);
		if(n>0)
			System.out.println("OK");
		
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
		SimpleJDBCInsertApp app=context.getBean(SimpleJDBCInsertApp.class);
		app.addStudent();

	}

}
