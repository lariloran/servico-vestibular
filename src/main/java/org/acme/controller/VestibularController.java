package org.acme.controller;

import java.util.ArrayList;
import java.util.List;

import org.acme.domain.Vestibular;
import org.acme.service.VestibularService;

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

@Path("/api/v1/vestibular")
public class VestibularController {

    @Inject
    VestibularService vestibularService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vestibular> ObterTodosVestibulares() {
        List<Vestibular> vestibulares = new ArrayList<>();

        try {
            vestibulares = vestibularService.ObterTodosVestibularesService();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vestibulares;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vestibular ObterVestibularPorId(@PathParam("id") Long id) {
        Vestibular vestibular = new Vestibular();

        try {
            vestibular = vestibularService.ObterVestibularPorIdService(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vestibular;
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void AdicionarVestibular(Vestibular vestibular){
            vestibularService.AdicionarVestibularService(vestibular);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AtualizarVestibular(@PathParam("id") Long id, Vestibular vestibular){
            vestibularService.AtualizarVestibularService(id, vestibular);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void RemoverVestibular(@PathParam("id") Long id){
            vestibularService.RemoverVestibularService(id);
    }
}
