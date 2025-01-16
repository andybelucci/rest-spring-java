package br.com.anderson.rest_spring_java;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
        @RequestParam(value= "name", defaultValue= "World") 
        String name) {
            return new Greeting(String.format(template, name), counter.incrementAndGet());
        }

}
