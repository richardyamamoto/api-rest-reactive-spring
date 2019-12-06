package br.com.reactiveapi.reactiveapi;

import br.com.reactiveapi.reactiveapi.model.Car;
import br.com.reactiveapi.reactiveapi.service.FluxCarService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RoutesHandles {
    private final FluxCarService fluxCarService;

    public RoutesHandles(FluxCarService fluxCarService) {
        this.fluxCarService = fluxCarService;
    }

    public Mono<ServerResponse> allCars(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(fluxCarService.all(), Car.class)
                .doOnError(throwable -> new IllegalStateException("allCars error"));
    }

    public Mono<ServerResponse> carById(ServerRequest serverRequest) {
        String carId = serverRequest.pathVariable("carId");
        return ServerResponse.ok()
                .body(fluxCarService.byId(carId), Car.class)
                .doOnError(throwable -> new IllegalStateException("carById error"));

    }

    public Mono<ServerResponse> events(ServerRequest serverRequest) {
        String carId = serverRequest.pathVariable("carId");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(fluxCarService.streams(carId), Car.class)
                .doOnError(throwable -> new IllegalStateException("events error"));
    }

}

