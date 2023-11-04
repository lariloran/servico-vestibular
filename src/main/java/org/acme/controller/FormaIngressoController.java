package org.acme.controller;

import java.util.ArrayList;
import java.util.List;

import org.acme.domain.FormaIngresso;
import org.acme.service.FormaIngressoService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/forma-ingresso")
public class FormaIngressoController {

    @Inject
    FormaIngressoService formaIngressoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FormaIngresso> ObterTodosFormasIngresso() {
        List<FormaIngresso> formasIngresso = new ArrayList<>();

        try {
            formasIngresso = formaIngressoService.ObterTodasFormasIngressoService();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formasIngresso;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FormaIngresso ObterFormaIngressoPorId(@PathParam("id") Long id) {
        FormaIngresso formaIngresso = new FormaIngresso();

        try {
            formaIngresso = formaIngressoService.ObterFormaIngressoPorIdService(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formaIngresso;
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void AdicionarFormaIngresso(FormaIngresso formaIngresso) {
        formaIngressoService.AdicionarFormaIngressoService(formaIngresso);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AtualizarFormaIngresso(@PathParam("id") Long id, FormaIngresso formaIngresso) {
        formaIngressoService.AtualizarFormaIngressoService(id, formaIngresso);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void RemoverFormaIngresso(@PathParam("id") Long id) {
        formaIngressoService.RemoverFormaIngressoService(id);
    }
}
