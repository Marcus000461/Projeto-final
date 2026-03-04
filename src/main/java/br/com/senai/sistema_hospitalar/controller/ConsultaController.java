package br.com.senai.sistema_hospitalar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sistema_hospitalar.entity.Consulta;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.ConsultaRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
   
    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    public Response adicionaConsulta(@Valid @RequestBody Consulta consulta){
        repository.save(consulta);
        return new Response(201, "Consulta não encontrada");
    }


}
