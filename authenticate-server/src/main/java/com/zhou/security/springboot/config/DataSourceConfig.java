package com.zhou.security.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create().
                url(url).
                username(username).
                password(password).
                driverClassName(driverClassName).
                build();
        return dataSource;
    }


    @Bean
    public ClientDetailsService clientDetailsService() {
        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource());
        clientDetailsService.setPasswordEncoder(new BCryptPasswordEncoder());
        return clientDetailsService;
    }


}
