package cn.cloud.octagon.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OctagonApplication {

    public static void main(String[] args) {
        SpringApplication.run(OctagonApplication.class, args);
    }

    // @Bean
    // public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    //     return builder.routes()
    //         .route("path_route", r -> r.path("/get")
//             .uri("http://127.0.0.1:8223"))
    //         .build();
    // }

}
