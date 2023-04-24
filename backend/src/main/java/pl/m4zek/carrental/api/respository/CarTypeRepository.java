package pl.m4zek.carrental.api.respository;

import pl.m4zek.carrental.api.model.CarType;

import java.util.List;
import java.util.Optional;

public interface CarTypeRepository {

    CarType save(CarType source);

    List<CarType> findAll();

    boolean existsByName(String name);

    Optional<CarType> findByName(String name);
}
