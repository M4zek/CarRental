package pl.m4zek.carrental.api.logic;

import org.springframework.stereotype.Service;
import pl.m4zek.carrental.api.model.CarClass;
import pl.m4zek.carrental.api.respository.CarClassRepository;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


@Service
public class CarClassService {

    private final CarClassRepository repository;

    public CarClassService(CarClassRepository repository) {
        this.repository = repository;
    }


    public String save(String source) throws Exception {
        if(!repository.existsByName(source)){
            CarClass newClass = repository.save(new CarClass(source.toLowerCase()));
            return newClass.getName();
        }
        throw new Exception("Car class already exists!");
    }

    public List<String> findAll(){
        return repository.findAll().stream()
                .map(CarClass::getName)
                .collect(Collectors.toList());
    }

}
