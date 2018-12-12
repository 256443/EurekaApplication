package com.antoszek.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.antoszek.eureka", "com.antoszek.eureka.repository",
        "com.antoszek.eureka.services"})
@EnableJpaRepositories(basePackages = "com.antoszek.eureka.repository")
public class OfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class, args);
    }
}
