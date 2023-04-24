package pl.m4zek.carrental.api.model.projection;

import io.swagger.annotations.ApiModelProperty;
import pl.m4zek.carrental.api.model.Car;

import java.util.List;


public class CarWriteModel {

    @ApiModelProperty(notes = "Vehicle brand", example = "Audi", required = true)
    private final String brand;

    @ApiModelProperty(notes = "Vehicle model", example = "A3", required = true)
    private final String model;

    @ApiModelProperty(notes = "Number of doors in the vehicle", example = "5", required = true)
    private final Integer door;

    @ApiModelProperty(notes = "Vehicle gearbox", example = "manual", required = true)
    private final String gearbox;

    @ApiModelProperty(notes = "Vehicle trunk capacity", example = "5", required = true)
    private final Integer trunk_capacity;

    @ApiModelProperty(notes = "Number of seats in the car (with driver)", example = "5", required = true)
    private final Integer passengers;

    @ApiModelProperty(notes = "Year of vehicle production", example = "2020", required = true)
    private final Integer year_of_production;

    @ApiModelProperty(notes = "Vehicle fuel type", example = "Diesel", required = true)
    private final String fuel_type;

    @ApiModelProperty(notes = "Horsepower of vehicle", example = "122", required = true)
    private final Integer horsepower;

    @ApiModelProperty(notes = "Engine capacity of vehicle", example = "1450", required = true)
    private final Integer engine_capacity;

    @ApiModelProperty(notes = "Car class of vehicle", example = "A", required = true)
    private final String car_class;

    @ApiModelProperty(notes = "Car type of vehicle", example = "Sedan", required = true)
    private final String car_type;

    @ApiModelProperty(notes = "Car type of vehicle", example = "[Heated seats, Auto alarm]", required = true)
    private List<String> equipmentList;


    public CarWriteModel(String brand, String model, Integer door, String gearbox, Integer trunk_capacity, Integer passengers, Integer year_of_production, String fuel_type, Integer horsepower, Integer engine_capacity, String car_class, String car_type, List<String> equipmentList) {
        this.brand = brand;
        this.model = model;
        this.door = door;
        this.gearbox = gearbox;
        this.trunk_capacity = trunk_capacity;
        this.passengers = passengers;
        this.year_of_production = year_of_production;
        this.fuel_type = fuel_type;
        this.horsepower = horsepower;
        this.engine_capacity = engine_capacity;
        this.car_class = car_class;
        this.car_type = car_type;
        this.equipmentList = equipmentList;
    }

    public String getCar_class() {
        return car_class;
    }

    public String getCar_type() {
        return car_type;
    }

    public List<String> getEquipmentList() {
        return equipmentList;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getDoor() {
        return door;
    }

    public String getGearbox() {
        return gearbox;
    }

    public Integer getTrunk_capacity() {
        return trunk_capacity;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public Integer getYear_of_production() {
        return year_of_production;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public Integer getEngine_capacity() {
        return engine_capacity;
    }

    public void setEquipmentList(List<String> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public Car toCar(){
        Car car = new Car();
        car.setBrand(this.brand);
        car.setModel(this.model);
        car.setDoor(this.door);
        car.setGearbox(this.gearbox);
        car.setTrunk_capacity(this.trunk_capacity);
        car.setPassengers(this.passengers);
        car.setYear_of_production(this.year_of_production);
        car.setFuel_type(this.fuel_type);
        car.setHorsepower(this.horsepower);
        car.setEngine_capacity(this.engine_capacity);
        return car;
    }
}
