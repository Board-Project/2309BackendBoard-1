package com.github.board.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@RequiredArgsConstructor
public class JdbcConfig {
    //Jdbc 관련 빈 등록

    @Bean
    public DataSource dataSource1(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://project-1.cehckoacemxp.ap-northeast-2.rds.amazonaws.com:3306/mydb");
        return dataSource;
    }



    @Bean
    public JdbcTemplate jdbcTemplate1(){
        return new JdbcTemplate(dataSource1());
    }


    @Bean(name="tm1")
    public PlatformTransactionManager transactionManager1() { return new DataSourceTransactionManager(dataSource1());}


}