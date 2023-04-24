package pl.m4zek.carrental.authorization.payload.response;

public class MessageResponse {

    private String message;

    public MessageResponse(String content) {
        this.message = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
