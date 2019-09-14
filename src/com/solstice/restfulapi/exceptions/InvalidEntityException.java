package com.solstice.restfulapi.exceptions;

import com.solstice.restfulapi.enums.ErrorCode;

public class InvalidEntityException extends SolsticeException {
    public InvalidEntityException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
