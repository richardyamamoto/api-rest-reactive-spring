package br.com.reactiveapi.reactiveapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@SpringBootApplication
public class ReactiveApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApiApplication.class, args);
    }

    @Bean
    RouterFunction<?> routes(RoutesHandles routesHandles) {
        return RouterFunctions.route(
                RequestPredicates.GET("/cars"), routesHandles::allCars)
                .andRoute(RequestPredicates.GET("/cars/{carId}"), routesHandles::carById)
                .andRoute(RequestPredicates.GET("/cars/{carId}/events"), routesHandles::events);

    }

}






