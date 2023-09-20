package com.riguz.adaptor.minimax;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class MinimaxResponseExceptionMapper implements ResponseExceptionMapper<RuntimeException> {
    @Override
    public RuntimeException toThrowable(Response response) {
        if (response.getStatus() != 200) {
            throw new RuntimeException("The remote service invoke failed with code=" + response.getStatus());
        }
        return null;
    }
}