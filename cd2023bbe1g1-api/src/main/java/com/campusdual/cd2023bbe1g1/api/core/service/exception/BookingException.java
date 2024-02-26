package com.campusdual.cd2023bbe1g1.api.core.service.exception;

public abstract class BookingException extends Exception {
    protected BookingException(String message) {
        super(message);
    }
}
