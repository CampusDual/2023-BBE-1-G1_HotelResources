package com.campusdual.cd2023bbe1g1.api.core.service.exception;

public abstract class UserDataException extends Exception {
    protected UserDataException(String message) {
        super(message);
    }
}
