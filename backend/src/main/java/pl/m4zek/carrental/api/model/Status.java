package pl.m4zek.carrental.api.model;

public enum Status {
    AVAILABLE("AVAILABLE"),
    RESERVED("RESERVED"),
    RENTED("RENTED");

    private String source;

    Status(String source){
        this.source = source;
    }

    public static Status fromString(String text) {
        for (Status b : Status.values()) {
            if (b.source.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
