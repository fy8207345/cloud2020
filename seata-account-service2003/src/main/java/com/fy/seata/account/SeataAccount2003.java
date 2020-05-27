package com.fy.seata.account;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
@EnableAutoDataSourceProxy
public class SeataAccount2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccount2003.class, args);
    }

}