package org.acme.service;

import org.acme.repository.CursoRepository;

import jakarta.inject.Inject;

public class CursoService {

   @Inject
   CursoRepository cursoRepository;
}
