package pl.m4zek.carrental.authorization.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.m4zek.carrental.authorization.model.Role;
import pl.m4zek.carrental.authorization.model.User;
import pl.m4zek.carrental.authorization.payload.request.SignupRequest;
import pl.m4zek.carrental.authorization.repository.RoleRepository;
import pl.m4zek.carrental.authorization.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(SignupRequest signupRequest) throws Exception{

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new Exception("Email is already in use!");
        }


        if(userRepository.existsByUsername(signupRequest.getUsername())){
            throw new Exception("Username is already in use!");
        }


        User user = signupRequest.getUserFromDto();
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        Set<Role> roles = signupRequest.getRoles().stream()
                .map(roleRepository::findByName)
                .collect(Collectors.toSet());

        if(roles.size() == 0){
            roles.add(roleRepository.findByName("USER"));
        }

        user.setRoles(roles);

        return userRepository.save(user);
    }

//    public User save(SignupRequest signupRequest) throws Exception{
//
//        if (userRepository.existsByEmail(signupRequest.getEmail())) {
//            throw new Exception("Email is already in use!");
//        }
//
//
//        if(userRepository.existsByUsername(signupRequest.getUsername())){
//            throw new Exception("Username is already in use!");
//        }
//
//        User user = signupRequest.getUserFromDto();
//        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
//
//        Role role = roleRepository.findByName("USER");
//
//        user.setRoles(new HashSet<>(Collections.singletonList(role)));
//        return userRepository.save(user);
//    }
}
