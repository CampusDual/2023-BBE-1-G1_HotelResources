package com.campusdual.cd2023bbe1g1.api.core.service.exception;

public class UserDoesNotExistException extends UserDataException {
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
