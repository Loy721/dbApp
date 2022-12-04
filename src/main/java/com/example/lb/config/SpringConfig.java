package com.example.lb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.management.ValueExp;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {




    @Value("${jdbc.URL}")
    private String URL;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
    DriverManagerDataSource dataSource= new DriverManagerDataSource();

    dataSource.setUrl(URL);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
    return new JdbcTemplate(dataSource());
    }
}
