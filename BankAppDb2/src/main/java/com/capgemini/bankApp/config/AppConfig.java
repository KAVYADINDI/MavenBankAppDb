package com.capgemini.bankApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.capgemini.bankApp"})
@PropertySource("classpath:application.properties")
public class AppConfig {
//	@Autowired
//	private Environment environment;
	@Value("${DB_URL}")
	private String dburl;
	
	@Value("${DB.USERNAME}")
	private String username;
	
	@Value("${DB.PASSWORD}")
	private String password;
	
	@Value("${path}")
	private String path;                                                    

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(path);
		dataSource.setUrl( dburl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
//		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
}