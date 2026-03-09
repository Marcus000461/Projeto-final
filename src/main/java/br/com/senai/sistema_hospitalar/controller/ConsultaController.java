package br.com.senai.sistema_hospitalar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sistema_hospitalar.entity.Consulta;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.ConsultaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
   
    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    public Response adicionaConsulta(@Valid @RequestBody Consulta consulta){
        repository.save(consulta);
        return new Response(200, "Consulta encontrada");
        // //O servidor não pode encontrar o recurso solicitado. 
   
   
    }

    @GetMapping
    public List<Consulta> retornaTodas(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response AtualizaConsulta(@PathVariable Long id, @RequestBody Consulta entity){
        
        if(!repository.existsById(id)){
            return new Response(404, "Consulta não atualizada"); //O servidor não pode encontrar o recurso solicitado.
        }
        
        
        Consulta consulta = repository.findById(id).get();
        if (entity.getData() != null) {
            consulta.setData(entity.getData());
        }

         if (entity.getDiagnostico() != null) {
            consulta.setDiagnostico(entity.getDiagnostico());
        }

        repository.save(consulta);
        return new Response(200, "Consulta atualizada"); // O produto será atualizado
    }

    public ConsultaRepository getRepository() {
        return repository;
    }

    public void setRepository(ConsultaRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/{id}")
    public Response deletaConsulta(@PathVariable Long id) {
        if (!repository.existsById(id)) {
             return new Response(404, "Consulta não deletada");//Consulta será deletada//
        }
         repository.deleteById(id);
        return new Response(200, "Consulta deletada");
    }


}
