package pl.m4zek.carrental.api.model.projection;

import java.util.Date;
import java.util.List;

public class OfferWriteModel {

    private final String car_id;

    private final Double price;

    private final String status;

    private final Date data_available;

    private final List<String> offer_role_ids;

    public OfferWriteModel(String car_id, Double price, String status, Date data_available, List<String> offer_role_ids) {
        this.car_id = car_id;
        this.price = price;
        this.status = status.trim().toUpperCase();
        this.data_available = data_available;
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

    public Date getData_available() {
        return data_available;
    }

    public List<String> getOffer_role_ids() {
        return offer_role_ids;
    }

    @Override
    public String toString() {
        return "OfferWriteModel{" +
                "car_id='" + car_id + '\'' +
                ", basic_price=" + price +
                ", status='" + status + '\'' +
                ", data_available=" + data_available +
                ", offer_role_ids=" + offer_role_ids +
                '}';
    }
}
