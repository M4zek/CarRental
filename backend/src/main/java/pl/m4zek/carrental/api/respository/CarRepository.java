package pl.m4zek.carrental.api.respository;

import pl.m4zek.carrental.api.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    Car save(Car source);
    List<Car> findAll();

    Optional<Car> findById(String id);

}
