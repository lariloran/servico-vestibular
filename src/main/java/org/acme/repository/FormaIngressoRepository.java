package org.acme.repository;

import org.acme.domain.FormaIngresso;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FormaIngressoRepository implements PanacheRepository<FormaIngresso>{
    
}
