package pl.m4zek.carrental.api.respository.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.m4zek.carrental.api.model.OfferRoles;
import pl.m4zek.carrental.api.respository.OfferRolesRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRolesMongoRepository extends OfferRolesRepository, MongoRepository<OfferRoles, String> {

    boolean existsByName(String name);
    Optional<OfferRoles> findById(String id);

    OfferRoles save(OfferRoles offerRoles);

    List<OfferRoles> findAll();
}
