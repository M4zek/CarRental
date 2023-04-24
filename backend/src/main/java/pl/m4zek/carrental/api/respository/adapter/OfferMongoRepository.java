package pl.m4zek.carrental.api.respository.adapter;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.m4zek.carrental.api.model.Offer;
import pl.m4zek.carrental.api.respository.OfferRepository;

import java.util.List;

public interface OfferMongoRepository extends OfferRepository, MongoRepository<Offer, String> {

    Offer save(Offer source);

    List<Offer> findAll();

}
