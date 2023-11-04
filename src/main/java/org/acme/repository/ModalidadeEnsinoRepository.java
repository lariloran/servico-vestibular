package org.acme.repository;

import org.acme.domain.ModalidadeEnsino;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ModalidadeEnsinoRepository implements PanacheRepository<ModalidadeEnsino>{
    
}
