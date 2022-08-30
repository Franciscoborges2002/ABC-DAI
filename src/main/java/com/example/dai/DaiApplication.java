package com.example.dai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.sql.*;

@SpringBootApplication()
public class DaiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(DaiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DaiApplication.class);
    }
}
