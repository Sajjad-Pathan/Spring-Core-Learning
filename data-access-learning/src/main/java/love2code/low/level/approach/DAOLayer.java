package love2code.low.level.approach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import love2code.platform.transaction.manager.Student;

@Repository
public class DAOLayer {
	@Autowired
	private  PlatformTransactionManager manager;
	@Autowired 
	private Connection connection;
	public DAOLayer() {}
	@Autowired
	public DAOLayer(PlatformTransactionManager manager, Connection connection) {
		this.manager = manager;
		this.connection=connection;
	}
	
	
	public void addStudent() {
		try {
			Statement statement= connection.createStatement();
			int num=statement.executeUpdate("insert into studentdatabase values(165,'Eddard Stark','8275179354')");
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getStudent() {
		try {
			Statement statement= connection.createStatement();
			ResultSet set=statement.executeQuery("select * from studentdatabase where id=165");
			while(set.next())
			System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getString(3));
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
