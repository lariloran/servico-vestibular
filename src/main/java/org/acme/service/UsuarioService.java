package org.acme.service;

import org.acme.repository.UsuarioRepository;

import jakarta.inject.Inject;

public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;
}
