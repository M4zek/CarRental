package pl.m4zek.carrental.api.respository;

import pl.m4zek.carrental.api.model.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository {
    boolean existsByName(String name);

    Equipment save(Equipment toEquipment);
    List<Equipment> findAll();

    Optional<Equipment> findByName(String name);
}
