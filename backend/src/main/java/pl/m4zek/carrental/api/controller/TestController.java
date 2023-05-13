package pl.m4zek.carrental.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.m4zek.carrental.api.logic.CarService;
import pl.m4zek.carrental.api.model.projection.CarReadModel;
import pl.m4zek.carrental.api.model.projection.CarWriteModel;


@RestController
public class TestController {

    private final CarService service;

    public TestController(CarService service) {
        this.service = service;
    }

    @PostMapping("/api/auth/test")
    public ResponseEntity<?> test(@RequestBody CarWriteModel source) {
        try {
            CarReadModel result = service.save(source);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/api/auth/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/api/v1/test")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<String> test2(){
        return ResponseEntity.ok("Hello World!");
    }


}
