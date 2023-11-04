package org.acme.service;

import java.util.List;

import org.acme.domain.Curso;
import org.acme.repository.CursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CursoService {

   @Inject
   CursoRepository cursoRepository;
    
    public List<Curso> ObterTodosCursosService(){
        return cursoRepository.findAll().list();
    }

    public Curso ObterCursoPorIdService(Long id){
        return cursoRepository.findById(id);
    }

    public void AdicionarCursoService(Curso curso){
        cursoRepository.persist(curso);
    }

    public void AtualizarCursoService(Long id,Curso curso){
        Curso obj = cursoRepository.findById(id);
        if(obj != null){
            obj.setNome(curso.getNome());
            obj.setDescricao(curso.getDescricao());
            cursoRepository.persist(obj);
        }
    }

    public void RemoverCursoService(Long id){
        cursoRepository.deleteById(id);
    }
}
