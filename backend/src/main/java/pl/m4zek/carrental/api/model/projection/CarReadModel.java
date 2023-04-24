package pl.m4zek.carrental.api.model.projection;

import pl.m4zek.carrental.api.model.Car;
import pl.m4zek.carrental.api.model.CarClass;
import pl.m4zek.carrental.api.model.CarType;
import pl.m4zek.carrental.api.model.Equipment;

import java.util.Set;

public class CarReadModel {

    private String id;
    private String brand;
    private String model;
    private Integer door;
    private String gearbox;
    private Integer trunk_capacity;
    private Integer passengers;
    private Integer year_of_production;
    private String fuel_type;
    private Integer horsepower;
    private Integer engine_capacity;
    private CarClass car_class;
    private CarType car_type;
    private Set<Equipment> equipmentList;

    public CarReadModel(Car car){
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.door = car.getDoor();
        this.gearbox = car.getGearbox();
        this.trunk_capacity = car.getTrunk_capacity();
        this.passengers = car.getPassengers();
        this.year_of_production = car.getYear_of_production();
        this.fuel_type = car.getFuel_type();
        this.horsepower = car.getHorsepower();
        this.engine_capacity = car.getEngine_capacity();
        this.car_class = car.getCar_class();
        this.car_type = car.getCar_type();
        this.equipmentList = car.getEquipmentList();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Integer getDoor() {
        return door;
    }
    public void setDoor(Integer door) {
        this.door = door;
    }
    public String getGearbox() {
        return gearbox;
    }
    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }
    public Integer getTrunk_capacity() {
        return trunk_capacity;
    }

    public void setTrunk_capacity(Integer trunk_capacity) {
        this.trunk_capacity = trunk_capacity;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public Integer getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(Integer year_of_production) {
        this.year_of_production = year_of_production;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Integer getEngine_capacity() {
        return engine_capacity;
    }

    public void setEngine_capacity(Integer engine_capacity) {
        this.engine_capacity = engine_capacity;
    }

    public CarClass getCar_class() {
        return car_class;
    }

    public void setCar_class(CarClass car_class) {
        this.car_class = car_class;
    }

    public CarType getCar_type() {
        return car_type;
    }

    public void setCar_type(CarType car_type) {
        this.car_type = car_type;
    }

    public Set<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(Set<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
