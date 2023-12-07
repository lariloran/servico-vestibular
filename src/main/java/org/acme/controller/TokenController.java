package org.acme.controller;

import java.util.ArrayList;
import java.util.List;

import org.acme.ITokenService;
import org.acme.domain.Curso;
import org.acme.service.CursoService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/token")
public class TokenController {

    @Inject
    @RestClient
    ITokenService service;

    @GET
    @Path("/jwt")
    @Produces(MediaType.APPLICATION_JSON)
    public String ObterToken() {
       return service.generator();
    }
}
