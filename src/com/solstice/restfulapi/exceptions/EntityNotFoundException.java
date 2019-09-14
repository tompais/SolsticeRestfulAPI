package com.solstice.restfulapi.exceptions;

import com.solstice.restfulapi.enums.ErrorCode;

public class EntityNotFoundException extends SolsticeException {
    public EntityNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
