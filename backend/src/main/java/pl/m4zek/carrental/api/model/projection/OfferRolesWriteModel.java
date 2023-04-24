package pl.m4zek.carrental.api.model.projection;

import pl.m4zek.carrental.api.model.OfferRoles;

public class OfferRolesWriteModel {

    private final String name;
    private final Double price;

    public OfferRolesWriteModel(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public OfferRoles toOfferRoles(){
        return new OfferRoles(this.name.toLowerCase(), this.price);
    }
}
