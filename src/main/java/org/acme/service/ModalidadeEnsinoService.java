package org.acme.service;

import java.util.List;

import org.acme.domain.ModalidadeEnsino;
import org.acme.repository.ModalidadeEnsinoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ModalidadeEnsinoService {

    @Inject
    ModalidadeEnsinoRepository modalidadeEnsinoRepository;

    public List<ModalidadeEnsino> ObterTodasModalidadesEnsinoService(){
        return modalidadeEnsinoRepository.findAll().list();
    }

    public void AdicionarModalidadeEnsinoService(ModalidadeEnsino modalidadeEnsino){
        modalidadeEnsinoRepository.persist(modalidadeEnsino);
    }
}
