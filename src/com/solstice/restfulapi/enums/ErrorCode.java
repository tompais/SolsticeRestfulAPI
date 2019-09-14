package com.solstice.restfulapi.enums;

public enum ErrorCode {

    DUPLICATEDENTITY(1),
    INVALIDENTITY(2),
    ENTITYNOTFOUND(3);

    private int codeNumber;

    ErrorCode(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    ErrorCode() {
    }

    public int getCodeNumber() {
        return codeNumber;
    }
}
