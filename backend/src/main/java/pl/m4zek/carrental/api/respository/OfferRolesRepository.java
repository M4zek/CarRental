package pl.m4zek.carrental.api.respository;

import pl.m4zek.carrental.api.model.OfferRoles;

import java.util.List;
import java.util.Optional;

public interface OfferRolesRepository {

    Optional<OfferRoles> findById(String id);

    OfferRoles save(OfferRoles offerRoles);

    List<OfferRoles> findAll();

    boolean existsByName(String name);

}
