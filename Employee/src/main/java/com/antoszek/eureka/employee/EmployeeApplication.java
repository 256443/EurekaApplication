package com.antoszek.eureka.employee;

import com.antoszek.eureka.employee.controllers.AssignEmployeeToOfficeController;
import com.antoszek.eureka.employee.model.Employee;
import com.antoszek.eureka.employee.repository.EmployeeRepository;
import com.antoszek.eureka.employee.services.EmployeeService;
import com.antoszek.eureka.employee.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeApplication {

    public EmployeeApplication() {
    }

    public static void main(String[] args) {

        SpringApplication.run(EmployeeApplication.class, args);


    }


}
