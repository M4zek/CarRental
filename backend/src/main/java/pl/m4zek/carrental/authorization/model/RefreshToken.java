package pl.m4zek.carrental.authorization.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("RefreshToken")
public class RefreshToken {

    @Id
    private String id;

    private User user;

    private String token;

    private Instant expireDate;

    public RefreshToken(User user, String token, Instant expireDate) {
        this.user = user;
        this.token = token;
        this.expireDate = expireDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Instant expireDate) {
        this.expireDate = expireDate;
    }
}
