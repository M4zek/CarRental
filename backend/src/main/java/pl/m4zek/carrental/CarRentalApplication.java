package pl.m4zek.carrental;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.m4zek.carrental.authorization.model.Role;
import pl.m4zek.carrental.authorization.payload.request.SignupRequest;
import pl.m4zek.carrental.authorization.service.RoleService;
import pl.m4zek.carrental.authorization.service.UserService;

import java.util.Collections;
import java.util.TimeZone;

@SpringBootApplication
public class CarRentalApplication {
    public static final Logger logger = LoggerFactory.getLogger(CarRentalApplication.class);


    final UserService userService;


    final RoleService roleService;

    public CarRentalApplication(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+2:00"));
        SpringApplication.run(CarRentalApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initDb(){
        logger.info("Initialize data in database");
        Role adminRole = roleService.save(new Role("ADMIN",
                "An Administrator provides office support to either an individual or " +
                        "team and is vital for the smooth-running of a business"));

        Role userRole =  roleService.save(new Role("USER",
                "A user role is a predefined category that can be assigned to " +
                        "users on the basis of their job title or some other criteria"));

        try {
            userService.save(new SignupRequest("Maikel", "Jordan","user@gmai.com","user","password", Collections.singletonList("USER")));
            userService.save(new SignupRequest("Steven", "Johns","admin@gmai.com","admin","password", Collections.singletonList("ADMIN")));
        } catch (Exception e){
            logger.info("Initialize database: {}", e.getMessage());
        }
    }

}
