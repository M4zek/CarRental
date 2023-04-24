package pl.m4zek.carrental.authorization.service;

import org.springframework.stereotype.Service;
import pl.m4zek.carrental.authorization.model.Role;
import pl.m4zek.carrental.authorization.repository.RoleRepository;


@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role save(Role role) {
        if(!repository.existsByName(role.getName())){
            Role newRole = new Role(role.getName(), role.getDescription());
            return repository.save(newRole);
        }
        return null;
    }
}
