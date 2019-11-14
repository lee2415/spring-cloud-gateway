package com.leel2415.springbackend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBackendApplication.class, args);
    }


    @GetMapping("/api/hello")
    public String hello(@RequestHeader HttpHeaders headers) {

        headers.entrySet().stream()
                .forEach(System.out::println);
        return "Hello world";
    }

    @GetMapping("/green/api/hello")
    public String blue_hello() {
        return "green Hello world";
    }

}
