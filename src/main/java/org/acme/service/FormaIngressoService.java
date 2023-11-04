package org.acme.service;

import java.util.List;

import org.acme.domain.FormaIngresso;
import org.acme.repository.FormaIngressoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FormaIngressoService {

    @Inject
    FormaIngressoRepository formaIngressoRepository;
    
    public List<FormaIngresso> ObterTodasFormasIngressoService(){
        return formaIngressoRepository.findAll().list();
    }

    public FormaIngresso ObterFormaIngressoPorIdService(Long id){
        return formaIngressoRepository.findById(id);
    }

    public void AdicionarFormaIngressoService(FormaIngresso formaIngresso){
        formaIngressoRepository.persist(formaIngresso);
    }

    public void AtualizarFormaIngressoService(Long id,FormaIngresso formaIngresso){
        FormaIngresso obj = formaIngressoRepository.findById(id);
        if(obj != null){
            obj.setNome(formaIngresso.getNome());
            formaIngressoRepository.persist(obj);
        }
    }

    public void RemoverFormaIngressoService(Long id){
        formaIngressoRepository.deleteById(id);
    }
}
