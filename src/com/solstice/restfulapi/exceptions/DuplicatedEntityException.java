package com.solstice.restfulapi.exceptions;

import com.solstice.restfulapi.enums.ErrorCode;

public class DuplicatedEntityException extends SolsticeException {
    public DuplicatedEntityException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
