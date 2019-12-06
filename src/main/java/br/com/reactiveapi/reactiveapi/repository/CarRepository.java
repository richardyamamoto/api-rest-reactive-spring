package br.com.reactiveapi.reactiveapi.repository;

import br.com.reactiveapi.reactiveapi.model.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository<Car, String> { }
