package pl.m4zek.carrental.api.model.projection;

import pl.m4zek.carrental.api.model.Car;
import pl.m4zek.carrental.api.model.Offer;
import pl.m4zek.carrental.api.model.Status;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OfferReadModel {

    private String id;

    private final Car car;

    private final Double price;

    private final Date data_available;

    private final Status status;
    private final List<OfferRolesReadModel> offerRoles;

    public OfferReadModel(Car car, Double price, Status status, Date data_available,  List<OfferRolesReadModel> offerRoles) {
        this.car = car;
        this.price = price;
        this.status = status;
        this.data_available = data_available;
        this.offerRoles = offerRoles;
    }

    public OfferReadModel(Offer source){
        this.id = source.getId();
        this.price = source.getPrice();
        this.status = source.getStatus();
        this.offerRoles = source.getOfferRoles()
                .stream()
                .map(OfferRolesReadModel::new)
                .collect(Collectors.toList());
        this.car = source.getCar();
        this.data_available = source.getAvailable_date();
    }

}
