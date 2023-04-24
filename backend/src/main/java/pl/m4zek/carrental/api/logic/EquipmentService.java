package pl.m4zek.carrental.api.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.m4zek.carrental.api.model.Equipment;
import pl.m4zek.carrental.api.respository.EquipmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EquipmentService {

    private final EquipmentRepository repository;

    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    public String save(String source) throws Exception {
        if(!repository.existsByName(source.toLowerCase())){
            Equipment newEquipment = repository.save(new Equipment(source.toLowerCase()));
            return newEquipment.getName();
        }
        throw new Exception("Equipment already exists!");
    }

    public List<String> findAll(){
        return repository.findAll().stream()
                .map(Equipment::getName)
                .collect(Collectors.toList());
    }

}
