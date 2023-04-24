package pl.m4zek.carrental.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.m4zek.carrental.api.logic.OfferRolesService;
import pl.m4zek.carrental.api.logic.OfferService;
import pl.m4zek.carrental.api.model.projection.OfferRolesWriteModel;
import pl.m4zek.carrental.api.model.projection.OfferWriteModel;
import pl.m4zek.carrental.authorization.payload.response.MessageResponse;

@RestController
@RequestMapping("/api/v1")
public class OfferController {

    private final OfferService offerService;
    private final OfferRolesService offerRolesService;

    public OfferController(OfferService offerService, OfferRolesService offerRolesService) {
        this.offerService = offerService;
        this.offerRolesService = offerRolesService;
    }

    @PostMapping("/offer")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewOffer(@RequestBody OfferWriteModel source){
        return ResponseEntity.ok(offerService.save(source));
    }

    @GetMapping("/offer")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> findAllOffer(){
        return ResponseEntity.ok(offerService.findAllOffer());
    }


    @PostMapping("/offerRoles")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewOfferRoles(@RequestBody OfferRolesWriteModel source){
        try {
            return ResponseEntity.ok(offerRolesService.save(source));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/offerRoles")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> readAllOfferRoles(){
        return ResponseEntity.ok(offerRolesService.readAll());
    }

}
