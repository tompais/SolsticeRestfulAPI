package com.solstice.restfulapi.exceptions;

import com.solstice.restfulapi.enums.ErrorCode;

public abstract class SolsticeException extends Exception {
    private ErrorCode errorCode;

    SolsticeException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
