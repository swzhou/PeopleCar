package com.peoplecar.service;

import com.peoplecar.domain.Greeting;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreetingServiceFacts {

    @Test
    public void should_greeting() {
        String expectedName = "Li Ming";
        String expectedMessage = "How do you do?";
        GreetingService greetingService = new GreetingService();

        Greeting greeting = greetingService.greeting(expectedName, expectedMessage);

        assertThat(greeting.getName(), is(expectedName));
        assertThat(greeting.getMessage(), is(expectedMessage));
    }
}
