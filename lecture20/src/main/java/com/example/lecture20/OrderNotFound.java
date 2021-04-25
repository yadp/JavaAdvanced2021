package com.example.lecture20;

//@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")  // 404
public class OrderNotFound extends RuntimeException{
    public OrderNotFound() {
    }

    public OrderNotFound(String message) {
        super(message);
    }

    public OrderNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderNotFound(Throwable cause) {
        super(cause);
    }

    public OrderNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
