package org.acme.service;

import java.util.List;

import org.acme.domain.Usuario;
import org.acme.repository.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;
    
    public List<Usuario> ObterTodosUsuariosService(){
        return usuarioRepository.findAll().list();
    }

    public Usuario ObterUsuarioPorIdService(Long id){
        return usuarioRepository.findById(id);
    }

    public void AdicionarUsuarioService(Usuario usuario){
        usuarioRepository.persist(usuario);
    }

    public void AtualizarUsuarioService(Long id,Usuario usuario){
        Usuario obj = usuarioRepository.findById(id);
        if(obj != null){
            obj.setNome(usuario.getNome());
            obj.setEmail(usuario.getEmail());
            obj.setSenha(usuario.getSenha());
            usuarioRepository.persist(obj);
        }
    }

    public void RemoverUsuarioService(Long id){
        usuarioRepository.deleteById(id);
    }
}
