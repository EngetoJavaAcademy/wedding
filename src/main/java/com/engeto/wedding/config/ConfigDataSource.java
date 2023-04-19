package com.engeto.wedding.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigDataSource {

    @Bean
    public static DataSource source(){
        DataSourceBuilder<?> db = DataSourceBuilder.create();

        db.driverClassName("com.mysql.jdbc.Driver");

        db.url("jdbc:mysql://localhost:3306/wedding");

        db.username("engeto");

        db.password("engeto");

        return db.build();
    }
}
