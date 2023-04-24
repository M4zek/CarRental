package pl.m4zek.carrental.api.respository.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.m4zek.carrental.api.model.CarClass;
import pl.m4zek.carrental.api.respository.CarClassRepository;

import java.util.List;
import java.util.Optional;

public interface CarClassMongoRepository extends CarClassRepository, MongoRepository<CarClass, String> {
    CarClass save(CarClass source);

    List<CarClass> findAll();

    @Override
    boolean existsByName(String name);

    Optional<CarClass> findByName(String name);
}
