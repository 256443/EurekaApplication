package com.antoszek.eureka.repository;


import com.antoszek.eureka.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends CrudRepository<Office, Long> {

}
