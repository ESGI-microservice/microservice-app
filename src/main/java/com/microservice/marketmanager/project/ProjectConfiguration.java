package com.microservice.marketmanager.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnits;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.microservice.marketmanager.project",
        entityManagerFactoryRef = "projectEntityManager",
        transactionManagerRef = "projectTransactionManager"
)
public class ProjectConfiguration {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public DataSource projectDataSource() {
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                "org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://35.180.253.24:5432/project_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    @Primary
    @PersistenceUnit
    public LocalContainerEntityManagerFactoryBean projectEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(projectDataSource());
        em.setPackagesToScan(
                "com.microservice.marketmanager.project");

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.ddl.auto",
                "create-drop");
        properties.put("hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect");
        em.setJpaPropertyMap(properties);

        return em;
    }



    @Primary
    @Bean
    public PlatformTransactionManager projectTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                projectEntityManager().getObject());
        return transactionManager;
    }


}
