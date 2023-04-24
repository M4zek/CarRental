package pl.m4zek.carrental.api.model.projection;

import pl.m4zek.carrental.api.model.Car;
import pl.m4zek.carrental.api.model.Offer;
import pl.m4zek.carrental.api.model.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OfferReadModel {

    private String id;

    private final Car car;

    private final Double price;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate availableDate;
    private final Status status;
    private final List<OfferRolesReadModel> offerRoles;

    public OfferReadModel(Car car, Double price, Status status, LocalDate availableDate, List<OfferRolesReadModel> offerRoles) {
        this.car = car;
        this.price = price;
        this.status = status;
        this.availableDate = availableDate;
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
        this.availableDate = source.getAvailableDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public Status getStatus() {
        return status;
    }

    public List<OfferRolesReadModel> getOfferRoles() {
        return offerRoles;
    }
}
