package org.acme.service;

import java.util.List;

import org.acme.domain.Vestibular;
import org.acme.repository.VestibularRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VestibularService {

   @Inject
   VestibularRepository vestibularRepository;

   public List<Vestibular> ObterTodosVestibularesService() {
      return vestibularRepository.findAll().list();
   }

   public Vestibular ObterVestibularPorIdService(Long id) {
      return vestibularRepository.findById(id);
   }

   public void AdicionarVestibularService(Vestibular vestibular) {
      vestibularRepository.persist(vestibular);
   }

   public void AtualizarVestibularService(Long id,Vestibular vestibular){
        Vestibular obj = vestibularRepository.findById(id);
        if(obj != null){
            obj.setNome(vestibular.getNome());
            obj.setSigla(vestibular.getSigla());
            obj.setDataInicio(vestibular.getDataInicio());
            obj.setDataFim(vestibular.getDataFim());
            obj.setNumeroEdital(vestibular.getNumeroEdital());
            obj.setSemestre(vestibular.getSemestre());
            obj.setAno(vestibular.getAno());
            obj.setDataCadastro(vestibular.getDataCadastro());
            obj.setAtivo(false);
            vestibularRepository.persist(obj);
        }
    }

   public void RemoverVestibularService(Long id) {
      vestibularRepository.deleteById(id);
   }
}
