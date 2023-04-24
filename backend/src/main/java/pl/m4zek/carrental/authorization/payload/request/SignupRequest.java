package pl.m4zek.carrental.authorization.payload.request;

import pl.m4zek.carrental.authorization.model.User;

import java.util.List;

public class SignupRequest {
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    private List<String> roles;

    public SignupRequest(String first_name, String last_name, String email, String username, String password, List<String> roles) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public User getUserFromDto(){
        return new User(
                this.first_name,
                this.last_name,
                this.username,
                this.email,
                this.password,
                null
        );
    }
}
