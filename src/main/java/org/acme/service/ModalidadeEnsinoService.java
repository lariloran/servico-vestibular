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

    public ModalidadeEnsino ObterModalidadesEnsinoPorIdService(Long id){
        return modalidadeEnsinoRepository.findById(id);
    }

    public void AdicionarModalidadeEnsinoService(ModalidadeEnsino modalidadeEnsino){
        modalidadeEnsinoRepository.persist(modalidadeEnsino);
    }

    public void AtualizarModalidadeEnsinoService(Long id,ModalidadeEnsino modalidadeEnsino){
        ModalidadeEnsino obj = modalidadeEnsinoRepository.findById(id);
        if(obj != null){
            obj.setNome(modalidadeEnsino.getNome());
            modalidadeEnsinoRepository.persist(obj);
        }
    }

    public void RemoverModalidadeEnsinoService(Long id){
        modalidadeEnsinoRepository.deleteById(id);
    }
}
