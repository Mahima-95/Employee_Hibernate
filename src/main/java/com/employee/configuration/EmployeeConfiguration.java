package com.employee.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.employee.pojo.Employee;

@Configuration
public class EmployeeConfiguration {
	
		@Bean(name = "dataSource")
		public DataSource getDataSource() {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/mahima"); /*10.2.0.207:3306*/
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			return dataSource;
		}

		// @Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
			LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(
					dataSource);
			sessionFactoryBuilder.addAnnotatedClass(Employee.class);
			sessionFactoryBuilder.addProperties(getHibernateProperties());
			return sessionFactoryBuilder.buildSessionFactory();
		}

		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.dialect",
					"org.hibernate.dialect.MySQLDialect");
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.current_session_context_class", "thread");
			return properties;
		}

}
