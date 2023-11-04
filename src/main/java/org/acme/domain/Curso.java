package org.acme.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;   
}
