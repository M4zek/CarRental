package pl.m4zek.carrental.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document(value = "offers")
public class Offer {

    @Id
    private String id;
    private Car car;
    private Double price;
    private List<OfferRoles> offerRoles;
    private Date available_date;
    private Status status;

    public Offer(Car car, Double price, List<OfferRoles> offerRoles, Status status, Date availableDate) {
        this.car = car;
        this.price = price;
        this.offerRoles = offerRoles;
        this.status = status;
        this.available_date = availableDate;
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

    public Date getAvailable_date() {
        return available_date;
    }

    public void setAvailable_date(Date available_date) {
        this.available_date = available_date;
    }
}