package pl.m4zek.carrental.api.model.projection;

import pl.m4zek.carrental.api.model.OfferRoles;

public class OfferRolesReadModel {

    private final String id;
    private final String name;
    private final Double price;

    public OfferRolesReadModel(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public OfferRolesReadModel(OfferRoles offerRoles){
        this.id = offerRoles.getId();
        this.name = offerRoles.getName();
        this.price = offerRoles.getPrice();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}
