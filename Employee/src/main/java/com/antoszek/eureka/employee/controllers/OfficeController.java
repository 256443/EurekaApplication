package com.antoszek.eureka.employee.controllers;

import com.antoszek.eureka.employee.model.Office;
import com.antoszek.eureka.employee.services.OfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/office")
public class OfficeController {

    private static final Logger log = LoggerFactory.getLogger(OfficeController.class);
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping("/all_office")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Office> getOffice(){
        List<Office> offices = officeService.findAll();
        log.info("Retrice objects {},", offices);
        return offices;
    }

    @RequestMapping("/add_office")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Office save(@RequestBody Office office){
        Office savedOffice = officeService.save(office);
        log.info("Add new office {}", "Id pracownika: "+savedOffice.getEmployee().getId());
        return savedOffice;
    }
    @GetMapping("/api/get_employee/{id}")
    public Optional<Office> findById(@PathVariable Long id){
        Optional<Office> employee = officeService.findById(id);
        return employee;
    }

    @PostConstruct
    public void addOffice(){
        Office o1 = new Office("Pracownik techniczny", 1);
        Office o2 = new Office("Serwisant", 2);
        Office o3 = new Office("Sekretarka", 3);
        Office o4 = new Office("Szef", 4);
        Office o5 = new Office("Kierownik zakładu", 5);
        Office o6 = new Office("Kierownik wydziału", 6);
        Office o7 = new Office("Menager", 7);
        officeService.save(o1);
        officeService.save(o2);
        officeService.save(o3);
        officeService.save(o4);
        officeService.save(o5);
        officeService.save(o6);
        officeService.save(o7);
    }
}
