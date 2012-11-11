package com.peoplecar.service;

import com.peoplecar.domain.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public Greeting greeting(String name, String message) {
        return new Greeting(name, message);
    }
}
