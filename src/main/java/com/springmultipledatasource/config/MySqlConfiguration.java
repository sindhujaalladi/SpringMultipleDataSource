package com.springmultipledatasource.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "com.springmultipledatasource.mysql.repository",
	entityManagerFactoryRef = MultipleDataSourceConstants.ENTITY_FACTORY_MANAGER_MYSQL,
	transactionManagerRef = MultipleDataSourceConstants.TRANSCATION_MANAGER_MYSQL)
//@PropertySource("classpath:Mysql.properties")
public class MySqlConfiguration {
	

		@Bean
	   // @ConfigurationProperties(prefix = "spring.datasource.mysql.hikari")
		@ConfigurationProperties(prefix="spring.second-datasource")
		public DataSourceProperties mysqldatasourceproperties () {
			return new DataSourceProperties();
		}
		
		@Bean(name = MultipleDataSourceConstants.DATASOURCE_MYSQL)
		public DataSource mysqldatasource(DataSourceProperties mysqldatasourceproperties ) {
			return  (DataSource) mysqldatasourceproperties.initializeDataSourceBuilder().build();
			
		}
		
		@Bean(name = MultipleDataSourceConstants.ENTITY_FACTORY_MANAGER_MYSQL )
		public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(@Qualifier("mysqlDataSource") DataSource mysqldatasource,EntityManagerFactoryBuilder builder) {
			 Map<String,String> hibernateProperties = new HashMap<>();
		        hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
		        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		        hibernateProperties.put("hibernate.show_sql", "true");
		        hibernateProperties.put("hibernate.format_sql", "true");
		        hibernateProperties.put("hibernate.hbm2ddl.import_files", "mysql.sql");

			return builder
					.dataSource(mysqldatasource)
					.packages("com.springmultipledatasource.mysql.Entity")
					.persistenceUnit("Mysql")
					.properties(hibernateProperties)
					.build();
		}
		
		@Bean(name = MultipleDataSourceConstants.TRANSCATION_MANAGER_MYSQL)
		public PlatformTransactionManager mysqlTrasncationManager(@Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean factory) {
			return new JpaTransactionManager(factory.getObject());
			
			
		}

	}



