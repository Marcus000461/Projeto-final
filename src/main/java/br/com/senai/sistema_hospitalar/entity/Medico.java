package br.com.senai.sistema_hospitalar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Medico {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "O nome precisa ser completo e não pode ficar vazio")
    private String nome;
    @Size(min= 8, max = 11, message = "O crm pode variar entre 8 e 11")
    private String crm;


    @ManyToOne
    @JoinColumn( name = "fk_ref_especialidade")
    private Especialidade especialidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }


    
}
