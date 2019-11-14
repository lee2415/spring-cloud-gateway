package com.leel2415.springfrontend;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8080", name = "TestClient")
public interface TestClient {

    @GetMapping("/api/hello")
    public String hello();
}
