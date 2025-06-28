package love2code.platform.transaction.manager;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "love2code.platform.transaction.manager")
public class BeanConfig {

	@Bean
	public DataSource dataSource() { 
		DriverManagerDataSource	ds=	new DriverManagerDataSource();
		ds.setUrl("jdbc:postgresql://localhost/postgres");
		ds.setPassword("Sajjad@321");
		ds.setUsername("postgres");
		ds.setDriverClassName("org.postgresql.Driver");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
}
