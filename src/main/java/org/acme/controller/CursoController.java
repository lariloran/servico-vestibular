package org.acme.controller;

import java.util.ArrayList;
import java.util.List;
import org.acme.domain.Curso;
import org.acme.service.CursoService;
import jakarta.annotation.security.RolesAllowed;
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

@Path("/api/v1/curso")
public class CursoController {

    @Inject
    CursoService cursoService;

    @GET
    @RolesAllowed("User")    
    @Produces(MediaType.APPLICATION_JSON)
    public List<Curso> ObterTodosCurso() {
        List<Curso> cursos = new ArrayList<>();

        try {
            cursos = cursoService.ObterTodosCursosService();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursos;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Curso ObterCursoPorId(@PathParam("id") Long id) {
        Curso curso = new Curso();

        try {
            curso = cursoService.ObterCursoPorIdService(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curso;
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void AdicionarCurso(Curso curso){
            cursoService.AdicionarCursoService(curso);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AtualizarCurso(@PathParam("id") Long id, Curso curso){
            cursoService.AtualizarCursoService(id, curso);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void RemoverCurso(@PathParam("id") Long id){
            cursoService.RemoverCursoService(id);
    }
}
