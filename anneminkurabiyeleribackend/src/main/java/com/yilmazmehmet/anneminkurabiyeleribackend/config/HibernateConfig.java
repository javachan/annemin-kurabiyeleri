package com.yilmazmehmet.anneminkurabiyeleribackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages={"com.yilmazmehmet.anneminkurabiyeleribackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/anneminkurabiyeleri";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	//datasource ayarlandı 
	@Bean("dataSource")
	public DataSource getDataSource(){
		BasicDataSource dataSoruce=new BasicDataSource();
		
		dataSoruce.setDriverClassName(DATABASE_DRIVER);
		dataSoruce.setUrl(DATABASE_URL);
		dataSoruce.setUsername(DATABASE_USERNAME);
		dataSoruce.setPassword(DATABASE_PASSWORD);
		
		return dataSoruce;
	}
	
	//sessionFactory için bean
	@Bean
	public SessionFactory getSessionFactory (DataSource dataSource){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.yilmazmehmet.anneminkurabiyeleribackend.dto");
		return builder.buildSessionFactory();
	}

	
	//Bütün hibernate özellikleri burdan dönecek
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		return properties;
	}
	
	//TransactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
