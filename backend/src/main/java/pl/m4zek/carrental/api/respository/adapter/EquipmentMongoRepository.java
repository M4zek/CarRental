package pl.m4zek.carrental.api.respository.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.m4zek.carrental.api.model.Equipment;
import pl.m4zek.carrental.api.respository.EquipmentRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentMongoRepository extends EquipmentRepository, MongoRepository<Equipment, String> {
    Optional<Equipment> findByName(String name);
    boolean existsByName(String name);

    Equipment save(Equipment toEquipment);
    List<Equipment> findAll();
}
