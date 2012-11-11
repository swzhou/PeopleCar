package com.peoplecar.controller;

import com.peoplecar.domain.Driver;
import com.peoplecar.dto.DriverDto;
import com.peoplecar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="drivers")
public class DriverController {
    private DriverService service;

    @Autowired
    public DriverController(DriverService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<DriverDto> index() {
        ArrayList<DriverDto> result = new ArrayList<DriverDto>();
        for(Driver driver: service.findAll()) {
            result.add(DriverDto.fromModel(driver));
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody DriverDto driverDto) {
        int id = service.create(driverDto.toModel());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("location", "/api/drivers/" + id);
        return new ResponseEntity<String>("", responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody DriverDto show(@PathVariable int id) {
        Driver driver = service.find(id);
        return DriverDto.fromModel(driver);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody DriverDto driverDto) {
        service.update(id, driverDto.toModel());
        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }
}
