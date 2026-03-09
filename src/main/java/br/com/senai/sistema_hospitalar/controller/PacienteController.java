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

import br.com.senai.sistema_hospitalar.entity.Paciente;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.PacienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public Response adicionaPaciente (@Valid @RequestBody Paciente paciente){
        repository.save(paciente);
        return new Response(200, "Paciente cadastrado");
    }

    @GetMapping
    public List<Paciente> retornaTodos(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizaPaciente(@PathVariable Long id, @RequestBody Paciente entity) {

        if(!repository.existsById(id)){
            return new Response(404, "Paciente não atualizada");
            
        }
        Paciente paciente = repository.findById(id).get();

         if (entity.getNome() != null) {
            paciente.setNome(entity.getNome());
        }

         if (entity.getCpf() != null) {
            paciente.setCpf(entity.getCpf());
        }

         if (entity.getData_nascimento() != null) {
            paciente.setData_nascimento(entity.getData_nascimento());
        }


        repository.save(paciente);

        return new Response(200, "Paciente Atualizada");
        
    }

    @DeleteMapping("/{id}")
    public Response deletaPaciente(@PathVariable Long id){
        if (!repository.existsById(id)){
             return new Response(404, "Paciente não deletado");
        }

            repository.deleteById(id);


        return new Response(200, "Paciente deletada");
    }
}
