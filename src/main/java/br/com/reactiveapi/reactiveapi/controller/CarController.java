package br.com.reactiveapi.reactiveapi.controller;

import br.com.reactiveapi.reactiveapi.events.CarEvents;
import br.com.reactiveapi.reactiveapi.model.Car;
import br.com.reactiveapi.reactiveapi.service.FluxCarService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// @RestController
public class CarController {

    private final FluxCarService fluxCarService;

    CarController(FluxCarService fluxCarService) {
        this.fluxCarService = fluxCarService;
    }

    @GetMapping("/cars")
    public Flux<Car> all() {
        return fluxCarService.all();
    }

    @GetMapping("/cars/{carId}")
    public Mono<Car> byId(@PathVariable String carId) {
        return fluxCarService.byId(carId);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/cars/{carId}/events")
    public Flux<CarEvents> eventsOfStreams(@PathVariable String carId) {
        return fluxCarService.streams(carId);
    }
}
