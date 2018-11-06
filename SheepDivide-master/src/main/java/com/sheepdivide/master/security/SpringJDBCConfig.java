package com.sheepdivide.master.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringJDBCConfig {
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://sheepdivide.crebnxmqviyd.eu-west-2.rds.amazonaws.com:3306/sheepdivide");
//        dataSource.setUsername("sheepuser");
//        dataSource.setPassword("jljsheep");

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sheepdivide");
        dataSource.setUsername("sheepdivideuser");
        dataSource.setPassword("sd123456");

        return dataSource;
    }
}

