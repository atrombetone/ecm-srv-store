package com.atrombetone.infrastructure;

import com.atrombetone.application.shared.dtos.in.response.ErrorResponse;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.inject.Inject;


@Provider
public class GlobalExceptionHandler  implements ExceptionMapper<Exception> {
    
    @Context
    UriInfo uriInfo;
    
    @Override
    public Response toResponse(Exception exception) {
        
        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                uriInfo.getPath(),
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
        );
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
    }
}
