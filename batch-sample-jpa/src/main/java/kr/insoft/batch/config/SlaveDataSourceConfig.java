package kr.insoft.batch.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
		entityManagerFactoryRef = "slaveEntityManagerFactory"
		, transactionManagerRef = "slaveTransactionManager"
		, basePackages = { "kr.insoft.batch.repository.slave" })
public class SlaveDataSourceConfig {

	@Bean(name = "slaveDataSourceProperties")
	@ConfigurationProperties( "spring.slave.datasource" )
	public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
	
	@Bean( name = "slaveDataSource" )
	public DataSource dataSource(@Qualifier("slaveDataSourceProperties") DataSourceProperties slaveDataSourceProperties) {
		return slaveDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Bean( name = "slaveEntityManagerFactory" )
	public LocalContainerEntityManagerFactoryBean entityManagerFactory (EntityManagerFactoryBuilder builder
			, @Qualifier("slaveDataSource") DataSource slaveDataSource) {
		return builder.dataSource(slaveDataSource)
						.packages("kr.insoft.batch.model.slave")
						.persistenceUnit("slave")
						.build();
	}
	
	@Bean( name = "slaveTransactionManager" )
	public PlatformTransactionManager transactionManager(@Qualifier("slaveEntityManagerFactory") EntityManagerFactory slaveEntityManagerFactory) {
		return new JpaTransactionManager(slaveEntityManagerFactory);
	}
}