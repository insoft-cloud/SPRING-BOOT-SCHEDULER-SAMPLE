package kr.insoft.batch.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MasterDataSourceConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.master.datasource")
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean 
	public SqlSessionFactory masterSqlSessionFactory(DataSource masterDataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(masterDataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/master/*.xml"));
		return sqlSessionFactoryBean.getObject(); 
	}
	
	@Bean
	public SqlSessionTemplate masterSqlSessionTemplate(SqlSessionFactory masterSqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(masterSqlSessionFactory);
	}
}
