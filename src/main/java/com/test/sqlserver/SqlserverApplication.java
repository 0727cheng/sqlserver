package com.test.sqlserver;

import com.bstek.ureport.console.UReportServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(basePackages="com.test.sqlserver.dao")
@ImportResource("classpath:context.xml")
public class SqlserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlserverApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean buildUReportServlet(){
        return new ServletRegistrationBean(new UReportServlet(), "/ureport/*");
    }
}
