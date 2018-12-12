package com.antoszek.eureka.repository;


import com.antoszek.eureka.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
