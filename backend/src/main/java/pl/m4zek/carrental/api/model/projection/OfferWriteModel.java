package pl.m4zek.carrental.api.model.projection;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class OfferWriteModel {

    private final String car_id;

    private final Double price;

    private final String status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate availableDate;

    private final List<String> offer_role_ids;

    public OfferWriteModel(String car_id, Double price, String status, LocalDate availableDate, List<String> offer_role_ids) {
        this.car_id = car_id;
        this.price = price;
        this.status = status.trim().toUpperCase();
        this.availableDate = availableDate;
        this.offer_role_ids = offer_role_ids;
    }

    public String getCar_id() {
        return car_id;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public List<String> getOffer_role_ids() {
        return offer_role_ids;
    }

}
