package com.example.eureka.controller;

import com.antoszek.eureka.Employee;
import com.antoszek.eureka.Office;
import com.antoszek.eureka.services.EmployeeService;
import com.antoszek.eureka.services.OfficeService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/assign")
public class AssignEmployeeToOfficeController {


    private final EmployeeService employeeService;
    private final OfficeService officeService;

    @Qualifier("eurekaClient")
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    public AssignEmployeeToOfficeController(EmployeeService employeeService, OfficeService officeService) {
        this.employeeService = employeeService;
        this.officeService = officeService;
    }

    @RequestMapping("/assigned_office/{officeId}/{employeeId}")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public String assignOfficeForEmployee(@PathVariable Long officeId, @PathVariable Long employeeId ){
        Optional<Office> office = officeService.findById(officeId);
        Optional<Employee> employee = employeeService.findById(employeeId);
        if(office.isPresent() && employee.isPresent()){
            Office f =office.get();
            f.setEmployee(employee.get());
            officeService.save(f);
            return "Assigned employee to office";
        }
        return "Not assigned... Error..";
    }



}
