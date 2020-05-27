package com.fy.seata.storage;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
@EnableAutoDataSourceProxy
public class SeataStorage2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorage2002.class, args);
    }

}