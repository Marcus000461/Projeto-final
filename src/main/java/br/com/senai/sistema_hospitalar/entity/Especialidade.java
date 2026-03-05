package br.com.senai.sistema_hospitalar.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Especialidade {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id ; 
    @NotBlank(message = "O nome precisa ser completo e não pode ficar vazio")
    private String nome;
    private String descricao;
    @Size(min=30, max= 60, message = "A descrição pode variar de tamanho")                                                                                                                                                                                                          
    
    
    @OneToMany
    @JoinColumn( name = "ref_especialidade")
    private List<Especialidade>especialidade;
    
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }





    
}
