package pl.m4zek.carrental.authorization.payload.request;

import io.swagger.annotations.ApiModelProperty;

public class LoginRequest {

    @ApiModelProperty(notes = "Username", example = "admin", required = true)
    private String username;

    @ApiModelProperty(notes = "Password", example = "password", required = true)
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
}


