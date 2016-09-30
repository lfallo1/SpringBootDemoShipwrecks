package com.lancefallon.boot.spring_boot_demo.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {

	/**
	 * could be a datasource connection that allows only basic CRUD operations, but not schema / structure changes
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}
	
	/**
	 * if perhaps, this datasource contains credentials that allow modification of db structure
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="datasource.flyway")
	@FlywayDataSource
	public DataSource flywayDataSource(){
		return DataSourceBuilder.create().build();
	}
	
}
