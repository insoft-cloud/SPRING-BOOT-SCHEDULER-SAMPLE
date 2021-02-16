package kr.insoft.batch.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
		entityManagerFactoryRef = "masterEntityManagerFactory"
		, transactionManagerRef = "masterTransactionManager"
		, basePackages = { "kr.insoft.batch.repository.master" })
public class MasterDataSourceConfig {

	@Primary
	@Bean(name = "masterDataSourceProperties")
	@ConfigurationProperties( "spring.master.datasource" )
	public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
	
	@Primary
	@Bean( name = "masterDataSource" )
	public DataSource dataSource(@Qualifier("masterDataSourceProperties") DataSourceProperties masterDataSourceProperties) {
		return masterDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean( name = "masterEntityManagerFactory" )
	public LocalContainerEntityManagerFactoryBean entityManagerFactory (EntityManagerFactoryBuilder builder
			, @Qualifier("masterDataSource") DataSource masterDataSource) {
		return builder.dataSource(masterDataSource)
						.packages("kr.insoft.batch.model.master")
						.persistenceUnit("master")
						.build();
	}
	
	@Primary
	@Bean( name = "masterTransactionManager" )
	public PlatformTransactionManager transactionManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory masterEntityManagerFactory) {
		return new JpaTransactionManager(masterEntityManagerFactory);
	}
}