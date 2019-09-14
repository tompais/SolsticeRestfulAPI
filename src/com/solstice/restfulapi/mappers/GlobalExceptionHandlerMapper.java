package com.solstice.restfulapi.mappers;

import com.solstice.restfulapi.exceptions.SolsticeException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Arrays;

@Provider
public class GlobalExceptionHandlerMapper implements ExceptionMapper<SolsticeException> {

    @Override
    public Response toResponse(SolsticeException exception) {
        return Response.status(500)
                .entity("ERROR Nro " + exception.getErrorCode().getCodeNumber() + ": " + exception.getMessage())
                .build();
    }
}
