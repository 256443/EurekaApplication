package com.antoszek.eureka.services;

import com.antoszek.eureka.Office;
import com.antoszek.eureka.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.inject.internal.util.Lists;
import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> findAll() {
        Iterable<Office> officeIterable = officeRepository.findAll();
        List<Office> offices = Lists.newArrayList(officeIterable);
        return offices;
    }

    public Office save(Office office) {
        Office savedOffice = officeRepository.save(office);
        return savedOffice;
    }

    public Optional<Office> findById(Long id) {
        Optional<Office> office = officeRepository.findById(id);
        if(office.isPresent()){
            return office;
        }
        return null;
    }

    public Office update(Office office) {
        Office updateOffice = officeRepository.save(office);

        return updateOffice;
    }
}
