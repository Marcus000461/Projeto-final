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

import br.com.senai.sistema_hospitalar.entity.Receita;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.ReceitaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
    
    @Autowired
    private ReceitaRepository repository;

    @PostMapping
    public Response adicionaReceita(@Valid @RequestBody Receita receita){
        repository.save(receita);
         return new Response(200, "Receita postada");
    }

    @GetMapping
    public List<Receita> retornaTodas(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response AtualizaReceita(@PathVariable Long id, @RequestBody Receita entity){

        if(!repository.existsById(id)){
            return new Response(404, "Não atualizada"); // O servidor não atualizará a receita
        }

        Receita receita = repository.findById(id).get();
         
        if (entity.getPaciente() != null) {
            receita.setPaciente(entity.getPaciente());
        }

         if (entity.getMedico() != null) {
            receita.setMedico(entity.getMedico());
        }

         if (entity.getData_emissão() != null) {
            receita.setData_emissão(entity.getData_emissão());

        }

         if (entity.getDesc_medicamento() != null) {
            receita.setDesc_medicamento(entity.getDesc_medicamento());
         }

        repository.save(receita);
        return new Response(200, "Receita atualizada");// O sistema atualizará um retorno pro usuário
    }

    @DeleteMapping("/{id}")
    public Response deletaReceita(@PathVariable Long id){
        if (!repository.existsById(id)){
             return new Response(404, "Receita não deletada"); // O servidor não trará nada 
        }

        repository.deleteById(id);
         return new Response(204, "Receita deletada"); // A receita será deletada.
    }
}
