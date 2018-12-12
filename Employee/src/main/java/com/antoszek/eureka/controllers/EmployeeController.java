package com.antoszek.eureka.controllers;


import com.antoszek.eureka.Employee;
import com.antoszek.eureka.services.EmployeeService;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/employee/service")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;


    @Qualifier("eurekaClient")
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping("/all_employees")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeService.findAll();
        log.info("Retrive objects {}", employees);
        return employees;
    }

    @RequestMapping("/add_employee")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Employee save(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.save(employee);
        log.info("Add new employee {}", savedEmployee);
        return savedEmployee;
    }

    @GetMapping("/api/get_employee/{id}")
    public Optional<Employee> findById(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        return employee;
    }
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Employee update(@RequestBody Employee user) {
        Employee updatedEmployee = employeeService.update(user);
        log.info("Updated Employee {}", updatedEmployee);

        return updatedEmployee;
    }

    @PostConstruct
    public void addEmployees(){
        Employee e1 = new Employee("Przemek", "Antoszek");
        Employee e2 = new Employee("Janusz", "Kowalski");
        Employee e3 = new Employee("Mariusz", "Janusz");
        Employee e4 = new Employee("Irek", "Wojewoda");
        Employee e5 = new Employee("Adam", "Borys");

    }
}
