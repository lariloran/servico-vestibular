package org.acme.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Vestibular {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String sigla;
    private Date dataInicio;
    private Date dataFim;
    private String numeroEdital;
    private String semestre;
    private int ano;
    private Date dataCadastro;
    private boolean ativo;
    //private List<FormaIngresso> formasIngresso; 
    //private List<ModalidadeEnsino> modalidadesEnsino;
}
