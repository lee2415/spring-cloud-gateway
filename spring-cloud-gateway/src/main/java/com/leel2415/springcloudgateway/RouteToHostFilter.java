package com.leel2415.springcloudgateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RouteToHostFilter extends AbstractGatewayFilterFactory<RouteToHostFilter.Config> {

    public RouteToHostFilter() {
        super(RouteToHostFilter.Config.class);
    }

    @Override
    public GatewayFilter apply(RouteToHostFilter.Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            HttpHeaders headers = request.getHeaders();

            headers.entrySet().stream()
                    .forEach(System.out::println);

            return chain.filter(exchange);
        };
    }

    // https://stackoverflow.com/questions/48221295/how-to-specify-custom-filter-in-application-yml-spring-cloud-gateway



    public static class Config {
        private String name;

        public Config(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
