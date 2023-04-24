package pl.m4zek.carrental.authorization.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.m4zek.carrental.authorization.model.User;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
