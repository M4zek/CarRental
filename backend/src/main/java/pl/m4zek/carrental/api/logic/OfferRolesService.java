package pl.m4zek.carrental.api.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.m4zek.carrental.api.model.OfferRoles;
import pl.m4zek.carrental.api.model.projection.OfferRolesReadModel;
import pl.m4zek.carrental.api.model.projection.OfferRolesWriteModel;
import pl.m4zek.carrental.api.respository.OfferRolesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OfferRolesService {


    private final OfferRolesRepository repository;

    public OfferRolesService(OfferRolesRepository repository) {
        this.repository = repository;
    }

    public OfferRolesReadModel save(OfferRolesWriteModel source) throws Exception{
        if(!repository.existsByName(source.getName().toLowerCase())){
            OfferRoles offerRoles = repository.save(source.toOfferRoles());
            return new OfferRolesReadModel(offerRoles);
        }
        throw new Exception("Offer roles already exists!");
}

    public List<OfferRolesReadModel> readAll(){
        return repository.findAll().stream()
                .map(OfferRolesReadModel::new)
                .collect(Collectors.toList());
    }

    public OfferRoles findSingleOfferRole(String id){
        return repository.findById(id).orElse(null);
    }

}