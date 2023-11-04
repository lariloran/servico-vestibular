package org.acme.service;

import org.acme.repository.VestibularRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VestibularService {

   @Inject
   VestibularRepository vestibularRepository;
}
