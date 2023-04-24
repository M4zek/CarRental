package pl.m4zek.carrental.api.logic;

import org.springframework.stereotype.Service;
import pl.m4zek.carrental.api.model.CarType;
import pl.m4zek.carrental.api.respository.CarTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarTypeService {

    private final CarTypeRepository carTypeRepository;

    public CarTypeService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    public String save(String source) throws Exception {
        if(!carTypeRepository.existsByName(source)){
            CarType carType = carTypeRepository.save(new CarType(source.toLowerCase()));
            return carType.getName();
        }
        throw new Exception("Car type already exists!");
    }

    public List<String> findAll(){
        return carTypeRepository.findAll().stream()
                .map(CarType::getName)
                .collect(Collectors.toList());
    }

}
