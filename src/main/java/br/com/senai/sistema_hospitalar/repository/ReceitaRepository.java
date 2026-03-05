package br.com.senai.sistema_hospitalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.sistema_hospitalar.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    
}
