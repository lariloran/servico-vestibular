package org.acme.controller;

import java.util.ArrayList;
import java.util.List;

import org.acme.domain.ModalidadeEnsino;
import org.acme.service.ModalidadeEnsinoService;

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

@Path("/api/v1/modalidade-ensino")
public class ModalidadeEnsinoController {

    @Inject
    ModalidadeEnsinoService modalidadeEnsinoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModalidadeEnsino> ObterTodasModalidadesEnsino() {
        List<ModalidadeEnsino> modalidadeEnsinos = new ArrayList<>();

        try {
            modalidadeEnsinos = modalidadeEnsinoService.ObterTodasModalidadesEnsinoService();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modalidadeEnsinos;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ModalidadeEnsino ObterModalidadesEnsinoPorId(@PathParam("id") Long id) {
        ModalidadeEnsino modalidadeEnsino = new ModalidadeEnsino();

        try {
            modalidadeEnsino = modalidadeEnsinoService.ObterModalidadesEnsinoPorIdService(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modalidadeEnsino;
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void AdicionarModalidadeEnsino(ModalidadeEnsino modalidadeEnsino){
            modalidadeEnsinoService.AdicionarModalidadeEnsinoService(modalidadeEnsino);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AtualizarModalidadeEnsino(@PathParam("id") Long id, ModalidadeEnsino modalidadeEnsino){
            modalidadeEnsinoService.AtualizarModalidadeEnsinoService(id, modalidadeEnsino);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void RemoverModalidadeEnsino(@PathParam("id") Long id){
            modalidadeEnsinoService.RemoverModalidadeEnsinoService(id);
    }

}
