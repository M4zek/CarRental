package pl.m4zek.carrental.api.respository.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.m4zek.carrental.api.model.CarType;
import pl.m4zek.carrental.api.respository.CarTypeRepository;

import java.util.List;
import java.util.Optional;

public interface CarTypeMongoRepository extends CarTypeRepository, MongoRepository<CarType, String> {

    CarType save(CarType source);

    List<CarType> findAll();

    boolean existsByName(String name);

    Optional<CarType> findByName(String name);
}
