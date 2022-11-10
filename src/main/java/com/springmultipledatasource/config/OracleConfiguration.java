package com.springmultipledatasource.config;

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
	basePackages = "com.springmultipledatasource.oracle.repository",
	entityManagerFactoryRef = MultipleDataSourceConstants.ENTITY_FACTORY_MANAGER_ORACLE,
	transactionManagerRef = MultipleDataSourceConstants.TRANSCATION_MANAGER_ORACLE
)
//@PropertySource("classpath:oracle.properties")
public class OracleConfiguration {
	
	@Primary
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
	public DataSourceProperties oracledatasourceproperties () {
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean(name = MultipleDataSourceConstants.DATASOURCE_ORACLE)
	public DataSource oracledatasource(DataSourceProperties oracledatasourceproperties ) {
		return  (DataSource) oracledatasourceproperties.initializeDataSourceBuilder().build();
		
		
	}
	
	@Primary
	@Bean(name = MultipleDataSourceConstants.ENTITY_FACTORY_MANAGER_ORACLE )
	public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(@Qualifier("oracleDataSource") DataSource oracledatasource,EntityManagerFactoryBuilder builder) {
		
		return builder
				.dataSource(oracledatasource)
				.packages("com.springmultipledatasource.oracle.Entity")
				.persistenceUnit("Oracle")
				.build();
	}
	
	@Primary
	@Bean(name = MultipleDataSourceConstants.TRANSCATION_MANAGER_ORACLE)
	public PlatformTransactionManager oracleTrasncationManager(@Qualifier("oracleEntityManagerFactory") LocalContainerEntityManagerFactoryBean factory) {
		return new JpaTransactionManager(factory.getObject());
		
		
	}

}
