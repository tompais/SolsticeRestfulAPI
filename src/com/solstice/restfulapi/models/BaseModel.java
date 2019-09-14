package com.solstice.restfulapi.models;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public abstract class BaseModel {
    @QueryParam("id")
    protected Long id;

    public final Long getId() {
        return id;
    }

    public final void setId(Long id) {
        this.id = id;
    }
}
