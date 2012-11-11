package com.peoplecar.service;

import com.peoplecar.domain.Driver;
import com.peoplecar.persistence.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriverService {

    private DriverRepository repository;

    public DriverService() {}

    @Autowired
    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Driver> findAll() {
        return repository.findAll();
    }

    @Transactional
    public int create(Driver driver) {
        return repository.create(driver);
    }

    @Transactional
    public Driver find(int id) {
        return repository.find(id);
    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }

    @Transactional
    public void update(int id, Driver driver) {
        repository.update(id, driver);
    }
}
