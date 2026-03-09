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

import br.com.senai.sistema_hospitalar.entity.Especialidade;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.EspecialidadeRepository;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {
    
    @Autowired
    private EspecialidadeRepository repository;
    
    @PostMapping
    public Response escolhaEspecialidade (@Valid @RequestBody Especialidade especialidade) {
        repository.save(especialidade);
        return new Response(200, "Especialidade encontrada");
         //O servidor não pode encontrar o recurso solicitado.
}

    @GetMapping
    public List<Especialidade> retornaTodas(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response AtualizaEspecie(@PathVariable Long id, @RequestBody Especialidade entity) {

        if(!repository.existsById(id)) {
             return new Response(404, "Especialidade não encontrada");
        }

        Especialidade especialidade = repository.findById(id).get();

          if (entity.getNome() != null) {
            especialidade.setNome(entity.getNome());
        }

          if (entity.getDescricao() != null) {
            especialidade.setDescricao(entity.getDescricao());
        }

         return new Response(200, "Especialidade encontrada");
    }

    @DeleteMapping("/{id}")
    public Response deleteEspecialidade(@PathVariable Long id){
        if(!repository.existsById(id)){
             return new Response(404, "Especialidade não deletada"); // Nesse erro não terá retorno
        }
         return new Response(200, "Especialidade deletada"); //Especialidade será deletada//
    }

}