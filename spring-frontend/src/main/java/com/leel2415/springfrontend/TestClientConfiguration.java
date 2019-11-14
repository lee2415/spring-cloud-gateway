package com.leel2415.springfrontend;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class TestClientConfiguration {

//    @Bean
//    public RequestInterceptor testClientReuqestHeader() {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//
//        RequestInterceptor requestInterceptor = requestTemplate -> Arrays.asList(request.getHeaderNames())
//                .stream().forEach(System.out::println);
//        return requestInterceptor;
//    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header("test", "Test");
            }
        };
        return requestInterceptor;
    }
}
