package pl.m4zek.carrental.api.respository;

import pl.m4zek.carrental.api.model.CarClass;

import java.util.List;
import java.util.Optional;

public interface CarClassRepository {

    List<CarClass> findAll();

    CarClass save(CarClass source);

    boolean existsByName(String name);

    Optional<CarClass> findByName(String name);
}
