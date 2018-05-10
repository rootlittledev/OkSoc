package com.ethero.quest.exception;

import com.ethero.quest.models.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException e) {
        String errorDocumentation = "https://ethero.com/Quest/doc/exceprions/DataNotFound";

        ErrorMessage errorMessage = new ErrorMessage(404, e.getMessage(), errorDocumentation);
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
