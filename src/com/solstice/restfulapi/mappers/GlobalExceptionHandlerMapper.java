package com.solstice.restfulapi.mappers;

import com.solstice.restfulapi.exceptions.SolsticeException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//This Mapper will catch all the exceptions that could be thrown during the runtime
//This is helpful, due to I can return a more "beautiful" and "comprehensible" text
//In case an exception is thrown
@Provider
public class GlobalExceptionHandlerMapper implements ExceptionMapper<SolsticeException> {

    @Override
    public Response toResponse(SolsticeException exception) {
        return Response.status(500)
                .entity("ERROR Nro " + exception.getErrorCode().getCodeNumber() + ": " + exception.getMessage())
                .build();
    }
}
