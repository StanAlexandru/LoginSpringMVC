/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author astan
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(
        basePackages = {"com.jbm.loginspringmvc.controller",
                        "com.jbm.loginspringmvc.service",
                        "com.jbm.loginspringmvc.repository"},
        excludeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.ANNOTATION,
                    value = EnableWebMvc.class
            )
        }
)
public class RootConfig {

    @Bean
    DataSource dataSource(){        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=Demo");
        dataSource.setUsername("rootUser");
        dataSource.setPassword("rootUser");
        return dataSource;
    }
    
    @Bean
    @Autowired        
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
    
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
    
    /*
    //add spring-jpa and hibernate-jpa-2.1-api to make this work
    @Bean
    LocalEntityManagerFactoryBean localEntityManagerFactoryBean(){
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("LoginSpringMvc_PU");
        return emfb;        
    }
    
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory localEntityManagerFactoryBean){
        return new JpaTransactionManager(localEntityManagerFactoryBean);
    }
    */
}
