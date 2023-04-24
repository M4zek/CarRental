package pl.m4zek.carrental.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(value = "offers")
public class Offer {

    @Id
    private String id;
    private Car car;
    private Double price;
    private List<OfferRoles> offerRoles;
    private LocalDate availableDate;
    private Status status;

    public Offer(Car car, Double price, List<OfferRoles> offerRoles, Status status, LocalDate availableDate) {
        this.car = car;
        this.price = price;
        this.offerRoles = offerRoles;
        this.status = status;
        this.availableDate = availableDate;
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

    public void setCar(Car car) {
        this.car = car;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<OfferRoles> getOfferRoles() {
        return offerRoles;
    }

    public void setOfferRoles(List<OfferRoles> offerRoles) {
        this.offerRoles = offerRoles;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
}