package com.example.service_one;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceOneController {

    private final RestTemplate restTemplate;

    public ServiceOneController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String home() {
        return "Hello, Welcome to Service One";
    }

    @GetMapping("/call")
    public String callServiceTwo() {

        String response =
                restTemplate.getForObject(
                        "http://service-two/",
                        String.class);

        return "Service One received -> " + response;
    }
}