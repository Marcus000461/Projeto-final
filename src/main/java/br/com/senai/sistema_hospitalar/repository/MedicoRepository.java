package br.com.senai.sistema_hospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sistema_hospitalar.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
}
