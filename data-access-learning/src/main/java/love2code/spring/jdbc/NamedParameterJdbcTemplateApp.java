package love2code.spring.jdbc;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Map;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import love2code.platform.transaction.manager.Student;
@Repository
public class NamedParameterJdbcTemplateApp {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	/*String sql = "select count(*) from t_actor where first_name = :firstName and last_name = :lastName";
	SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(exampleActor);
	return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);*/
	
	public void add() {
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(new Student(45,"NamedParameter App","1234567890"));
		jdbcTemplate.update("insert into studentdatabase values (:id, :name, :number)",parameterSource);
		
		Student student=jdbcTemplate.queryForObject("select * from studentdatabase where id=:id",parameterSource,new BeanPropertyRowMapper<>(Student.class));
		System.out.println(student.toString());
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(BeanConfig.class);
		NamedParameterJdbcTemplateApp app=context.getBean(NamedParameterJdbcTemplateApp.class);
		app.add();

	}

}
