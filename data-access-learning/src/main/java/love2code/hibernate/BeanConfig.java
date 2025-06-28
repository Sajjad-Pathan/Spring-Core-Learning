package love2code.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = "love2code.hibernate")
@Configuration
@EnableTransactionManagement
public class BeanConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost/postgres");
		dataSource.setPassword("Sajjad@321");
		dataSource.setUsername("postgres");
		dataSource.setDriverClassName("org.postgresql.Driver");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.example.model");

		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.show_sql", "true");

		// Optional: for compatibility
		props.setProperty("hibernate.transaction.coordinator_class", "jdbc");

		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory localSessionFactoryBean) {
		return new HibernateTransactionManager(localSessionFactoryBean);
	}

}
