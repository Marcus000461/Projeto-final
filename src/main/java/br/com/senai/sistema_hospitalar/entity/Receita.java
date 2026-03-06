package br.com.senai.sistema_hospitalar.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Receita {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "fk_medico")
    private Medico medico;
    @PastOrPresent
    private LocalDate data_emissão;
    private String desc_medicamento;
   
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public LocalDate getData_emissão() {
        return data_emissão;
    }
    public void setData_emissão(LocalDate data_emissão) {
        this.data_emissão = data_emissão;
    }
    public String getDesc_medicamento() {
        return desc_medicamento;
    }
    public void setDesc_medicamento(String desc_medicamento) {
        this.desc_medicamento = desc_medicamento;
    }

    

    
}
