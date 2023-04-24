package pl.m4zek.carrental.api.respository;

import pl.m4zek.carrental.api.model.Offer;

import java.util.List;

public interface OfferRepository {

    Offer save(Offer source);

    List<Offer> findAll();
}
