package love2code.platform.transaction.manager;

import java.sql.ResultSet;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;


@ComponentScan
@Repository
public class DAOLayer {
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	@Autowired
	private  PlatformTransactionManager manager;
	
	public DAOLayer() {}
	@Autowired
	public DAOLayer(JdbcTemplate jdbcTemplate, PlatformTransactionManager manager) {
		this.jdbcTemplate = jdbcTemplate;
		this.manager = manager;
	}
	
	
	public void addStudent() {
		try {
			jdbcTemplate.execute("insert into studentdatabase values (101,'Sajjad Pathan','9699173489')");
			Student student=jdbcTemplate.queryForObject("select * from studentdatabase where id=101",(ResultSet set, int rowNum) -> new Student(set.getInt(1), set.getString(2), set.getString(3)));
			System.out.println(student);
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
