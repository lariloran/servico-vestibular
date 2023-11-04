package org.acme.controller;

import java.util.ArrayList;
import java.util.List;

import org.acme.domain.Usuario;
import org.acme.service.UsuarioService;
import org.acme.service.UsuarioService;

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

@Path("/api/v1/usuario")
public class UsuarioController {

  @Inject
    UsuarioService usuarioService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> ObterTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            usuarios = usuarioService.ObterTodosUsuariosService();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario ObterUsuarioPorId(@PathParam("id") Long id) {
        Usuario usuario = new Usuario();

        try {
            usuario = usuarioService.ObterUsuarioPorIdService(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void AdicionarUsuario(Usuario usuario){
            usuarioService.AdicionarUsuarioService(usuario);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AtualizarUsuario(@PathParam("id") Long id, Usuario usuario){
            usuarioService.AtualizarUsuarioService(id, usuario);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void RemoverUsuario(@PathParam("id") Long id){
            usuarioService.RemoverUsuarioService(id);
    }
}
