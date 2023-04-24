package pl.m4zek.carrental.api.controller;



import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.m4zek.carrental.api.logic.CarClassService;
import pl.m4zek.carrental.api.logic.CarService;
import pl.m4zek.carrental.api.logic.CarTypeService;
import pl.m4zek.carrental.api.logic.EquipmentService;
import pl.m4zek.carrental.api.model.projection.*;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    private final CarService carService;
    private final CarClassService carClassService;
    private final CarTypeService carTypeService;
    private final EquipmentService equipmentService;

    public CarController(CarService carService, CarClassService carClassService, CarTypeService carTypeService, EquipmentService equipmentService) {
        this.carService = carService;
        this.carClassService = carClassService;
        this.carTypeService = carTypeService;
        this.equipmentService = equipmentService;
    }

    @PostMapping("/car")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewCar(@RequestBody CarWriteModel source){
        try {
            CarReadModel result = carService.save(source);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/car")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> readAllCar(){
        return ResponseEntity.ok(carService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/carType/{car_type}")
    public ResponseEntity<?> addNewCarType(@PathVariable String car_type){
        try {
            String result = carTypeService.save(car_type);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/carType")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> readAllCarType(){
        return ResponseEntity.ok(carTypeService.findAll());
    }

    @PostMapping("/carClass/{car_class}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewCarClass(@PathVariable String car_class){
        try {
            String result = carClassService.save(car_class);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/carClass")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> readAllCarClass(){
        return ResponseEntity.ok(carClassService.findAll());
    }

    @PostMapping("/equipment/{car_eq}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewEquipment(@PathVariable String car_eq){
        try {
            String result = equipmentService.save(car_eq);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/equipment")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> readAllEquipment(){
        return ResponseEntity.ok(equipmentService.findAll());
    }
}