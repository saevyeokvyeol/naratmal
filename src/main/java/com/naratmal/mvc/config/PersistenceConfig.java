package com.naratmal.mvc.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration // Bean 등록 전용 클래스를 선언하기 위한 어노테이션
/**
 * <tx:annotation-driven transaction-manager="transactionManager"/> 태그를 대신하기 위해
 * TransactionManagementConfigurer 구현하고 @EnableTransactionManagement 어노테이션 입력
 * */
@EnableTransactionManagement
@PropertySource("classpath:config/dbInfo.properties") // properties 파일이 필요한 경우 가져옴
public class PersistenceConfig implements TransactionManagementConfigurer {
	
	@Autowired
	private Environment env; // properties 파일에 있는 모든 key와 value를 저장하는 객체
	
	/**
	 * PropertySourcesPlaceholderConfigurer 등록
	 * 프로퍼티 파일을 가져오는 객체이기 때문에 다른 빈보다 더 먼저 실행되어야 함
	 * 때문에 객체 생성 시 가장 먼저 실행되는 static 메소드로 제작
	 * */
	@Bean // Bean 등록을 위한 어노테이션
	public static PropertySourcesPlaceholderConfigurer getPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		
		return placeholderConfigurer;
	}
	
	/**
	 * SqlSessionFactoryBean 등록
	 * */
	@Bean // Bean 등록을 위한 어노테이션
	public SqlSessionFactoryBean getFactoryBean() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		// DataSource 등록
		factoryBean.setDataSource(getBasicDataSource());
		
		// mapper 등록
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml"));
		
		// 클래스 별칭 등록: yuda.mvc.dto 팩토리 안의 모든 클래스를 첫 글자를 소문자로 바꾼 클래스명으로
		factoryBean.setTypeAliasesPackage("com.naratmal.mvc.vo");
		
		// 마이바티스 설정파일 등록
		factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:config/mybatis-config.xml"));
		
		return factoryBean;
	}
	
	/**
	 * SqlSessionTemplate 등록
	 * */
	@Bean // Bean 등록을 위한 어노테이션
	public SqlSessionTemplate getSqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(getFactoryBean().getObject());
		
		return sqlSessionTemplate;
	}
		
	/**
	 * DataSource(DB 정보) 등록
	 * 임포트 시 org.apache.commons.dbcp.BasicDataSource로 임포트 해야 함
	 * */
	@Bean // Bean 등록을 위한 어노테이션
	public BasicDataSource getBasicDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		// Environment를 통해 value값을 가져옴
		dataSource.setDriverClassName(env.getProperty("db.driverName"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.userName"));
		dataSource.setPassword(env.getProperty("db.password"));
		dataSource.setMaxActive(10);
		
		return dataSource;
	}

	/**
	 * transaction 옵션 설정
	 * */
	@Bean // Bean 등록을 위한 어노테이션
	public DataSourceTransactionManager getTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		
		transactionManager.setDataSource(getBasicDataSource());
		
		return transactionManager;
	}
	
	/**
	 * TransactionManagementConfigurer 인터페이스를 구현해 오버라이딩된 메소드
	 * TransactionManager를 확장한 DataSourceTransactionManager를 사용할 것이기 때문에
	 * DataSourceTransactionManager를 리턴하는 getTransactionManager() 메소드를 리턴
	 * */
	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		return this.getTransactionManager();
	}
}