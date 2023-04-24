package pl.m4zek.carrental.api.respository.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.m4zek.carrental.api.model.Car;
import pl.m4zek.carrental.api.respository.CarRepository;

import java.util.List;
import java.util.Optional;

public interface CarMongoRepository extends CarRepository, MongoRepository<Car, String> {

    Car save(Car source);

    List<Car> findAll();
    Optional<Car> findById(String id);
}
