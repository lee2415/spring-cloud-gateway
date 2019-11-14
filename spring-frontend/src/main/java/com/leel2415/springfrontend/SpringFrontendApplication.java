package com.leel2415.springfrontend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
@Slf4j
public class SpringFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFrontendApplication.class, args);
    }

    @Autowired
    TestClient testClient;

    @GetMapping("/hello")
    public String hello(@RequestHeader HttpHeaders headers) {

        headers.entrySet().stream()
                .forEach(System.out::println);
        return testClient.hello();
    }


    @GetMapping("/api/hello")
    public String helloResult() {
        return "GREEN HELLO";
    }

}
