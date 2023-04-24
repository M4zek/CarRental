package pl.m4zek.carrental.api.logic;

import org.springframework.stereotype.Service;
import pl.m4zek.carrental.api.model.Car;
import pl.m4zek.carrental.api.model.projection.CarReadModel;
import pl.m4zek.carrental.api.model.projection.CarWriteModel;
import pl.m4zek.carrental.api.respository.CarClassRepository;
import pl.m4zek.carrental.api.respository.CarRepository;
import pl.m4zek.carrental.api.respository.CarTypeRepository;
import pl.m4zek.carrental.api.respository.EquipmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final EquipmentRepository equipmentRepository;
    private final CarTypeRepository carTypeRepository;
    private final CarClassRepository carClassRepository;

    public CarService(CarRepository carRepository, EquipmentRepository equipmentRepository, CarTypeRepository carTypeRepository, CarClassRepository carClassRepository) {
        this.carRepository = carRepository;
        this.equipmentRepository = equipmentRepository;
        this.carTypeRepository = carTypeRepository;
        this.carClassRepository = carClassRepository;
    }


    public CarReadModel save(CarWriteModel source) {
        Car newCar = source.toCar();
        newCar.setCar_type(carTypeRepository.findByName(source.getCar_type().toLowerCase().trim()).get());
        newCar.setCar_class(carClassRepository.findByName(source.getCar_class().toLowerCase().trim()).get());
        newCar.setEquipmentList(source.getEquipmentList().stream()
                .map(item -> equipmentRepository.findByName(item.toLowerCase()).get())
                .collect(Collectors.toSet())
        );

        return new CarReadModel(carRepository.save(newCar));
    }


    public List<CarReadModel> findAll(){
        return carRepository.findAll().stream()
                .map(CarReadModel::new)
                .collect(Collectors.toList());
    }

    public Car findSingleCar(String id){
        return carRepository.findById(id).orElse(null);
    }


}
