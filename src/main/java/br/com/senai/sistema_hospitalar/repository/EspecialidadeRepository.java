package br.com.senai.sistema_hospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sistema_hospitalar.entity.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    
}
