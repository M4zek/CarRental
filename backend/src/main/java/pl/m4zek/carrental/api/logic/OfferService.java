package pl.m4zek.carrental.api.logic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.m4zek.carrental.api.model.Offer;
import pl.m4zek.carrental.api.model.Status;
import pl.m4zek.carrental.api.model.projection.OfferReadModel;
import pl.m4zek.carrental.api.model.projection.OfferWriteModel;
import pl.m4zek.carrental.api.respository.OfferRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OfferService {

    private final OfferRepository repository;
    private final CarService carService;
    private final OfferRolesService offerRolesService;

    public OfferService(OfferRepository repository, CarService carService, OfferRolesService offerRolesService) {
        this.repository = repository;
        this.carService = carService;
        this.offerRolesService = offerRolesService;
    }

    public OfferReadModel save(OfferWriteModel source){
        return new OfferReadModel(repository.save(new Offer(
                carService.findSingleCar(source.getCar_id()),
                source.getPrice(),
                source.getOffer_role_ids().stream()
                        .map(offerRolesService::findSingleOfferRole)
                        .collect(Collectors.toList()),
                Status.valueOf(source.getStatus()),
                source.getAvailableDate()
                )));
    }

    public List<OfferReadModel> findAllOffer(){
        return repository.findAll().stream()
                .map(OfferReadModel::new)
                .collect(Collectors.toList());
    }
}
