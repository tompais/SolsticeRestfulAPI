package com.solstice.restfulapi.models;

public abstract class BaseModel {
    private int id;

    protected final int getId() {
        return id;
    }

    protected final void setId(int id) {
        this.id = id;
    }
}
