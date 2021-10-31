package com.example;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.example.dao.CalenderDao;
import com.example.dao.MemberDao;
import com.example.dao.MemoDao;


@Configuration
public class JavaConfig {
	
	@Autowired
	ApplicationContext applicationContext; 


	@Bean
	public DriverManagerDataSource datasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost/midterm?characterEncoding=utf8&serverTimezone=UTC");
		datasource.setUsername("root");
		datasource.setPassword("1234");
		return datasource;
	}
	
	@Bean
	public SqlSessionFactory MemberFactory() throws Exception
	{
		SqlSessionFactoryBean Memberfactory = new SqlSessionFactoryBean();
		Memberfactory.setDataSource(datasource());
		Memberfactory.setTypeAliases(Member.class);
		Memberfactory.setMapperLocations(applicationContext.getResource("classpath:com/example/dao/MemberMapper.xml"));
		return Memberfactory.getObject();
	}
	
	@Bean
	public SqlSessionFactory MemoFactory() throws Exception
	{
		SqlSessionFactoryBean MemoFactory = new SqlSessionFactoryBean();
		MemoFactory.setDataSource(datasource());
		MemoFactory.setTypeAliases(Memo.class);
		MemoFactory.setMapperLocations(applicationContext.getResource("classpath:com/example/dao/MemoMapper.xml"));
		return MemoFactory.getObject();
	}
	
	@Bean
	public SqlSessionFactory CalenderFactory() throws Exception
	{
		SqlSessionFactoryBean CalenderFactory = new SqlSessionFactoryBean();
		CalenderFactory.setDataSource(datasource());
		CalenderFactory.setTypeAliases(Calender.class);
		CalenderFactory.setMapperLocations(applicationContext.getResource("classpath:com/example/dao/CalenderMapper.xml"));
		return CalenderFactory.getObject();
	}
	@Bean
	public SqlSessionTemplate MemberFactoryTemplate() throws Exception
	{
		return new SqlSessionTemplate(MemberFactory());
		
	}
	@Bean
	public SqlSessionTemplate MemoFactoryTemplate() throws Exception
	{
		return new SqlSessionTemplate(MemoFactory());
		
	}
	@Bean
	public SqlSessionTemplate CalenderFactoryTemplate() throws Exception
	{
		return new SqlSessionTemplate(CalenderFactory());
		
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	
	@Bean
	public CalenderSearch cSearch() throws Exception
	{
		return new CalenderSearch(CalenderFactoryTemplate().getMapper(CalenderDao.class));
	}
	@Bean
	public MemoSearch memoSearch() throws Exception
	{
		return new MemoSearch(MemoFactoryTemplate().getMapper(MemoDao.class));
	}
	
	@Bean  
	public MemberRegisterService memberRegSvc() throws Exception
	{
		MemberRegisterService memberRegSvc = new MemberRegisterService();
		memberRegSvc.setmemberDao(MemberFactoryTemplate().getMapper(MemberDao.class));
		return memberRegSvc;
		
	}
	
	@Bean
	public MemberInfo mInfo() throws Exception
	{
		return new MemberInfo(MemberFactoryTemplate().getMapper(MemberDao.class));
	}
	

	@Bean
	public CalenderInfo cInfo() throws Exception
	{
		CalenderInfo cInfo = new CalenderInfo(CalenderFactoryTemplate().getMapper(CalenderDao.class));
		return cInfo;
	}
	
	@Bean
	public MemoInfo memoinfo() throws Exception
	{
		MemoInfo memoinfo = new MemoInfo(MemoFactoryTemplate().getMapper(MemoDao.class));
		return memoinfo;
	}
 

}

