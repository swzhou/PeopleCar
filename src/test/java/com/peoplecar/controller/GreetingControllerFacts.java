package com.peoplecar.controller;

import com.peoplecar.domain.Greeting;
import com.peoplecar.service.GreetingService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GreetingControllerFacts {
    @Test
    public void should_greeting_to_given_somebody() {
        Greeting expectedGreeting = new Greeting("Li Ming", "How are you?");
        GreetingController controller = givenGreetingController(expectedGreeting);

        Greeting greeting = controller.greeting(expectedGreeting.getName(), null);

        assertThat(greeting, is(expectedGreeting));
    }

    private GreetingController givenGreetingController(Greeting expectedGreeting) {
        GreetingService service = mock(GreetingService.class);
        when(service.greeting(expectedGreeting.getName(), expectedGreeting.getMessage())).thenReturn(expectedGreeting);
        return new GreetingController(service);
    }

}
