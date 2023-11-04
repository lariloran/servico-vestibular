package org.acme.repository;

import org.acme.domain.Vestibular;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VestibularRepository implements PanacheRepository<Vestibular>{
    
}
