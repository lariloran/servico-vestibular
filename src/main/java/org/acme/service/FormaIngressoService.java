package org.acme.service;

import org.acme.repository.FormaIngressoRepository;

import jakarta.inject.Inject;

public class FormaIngressoService {

    @Inject
    FormaIngressoRepository formaIngressoRepository;

    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}
