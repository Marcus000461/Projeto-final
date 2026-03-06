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

import br.com.senai.sistema_hospitalar.entity.Medico;
import br.com.senai.sistema_hospitalar.exception.Response;
import br.com.senai.sistema_hospitalar.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public Response adicionaMedico(@Valid @RequestBody Medico medico){
        repository.save(medico);
         return new Response(204, " Medico não encontrado"); //atualiza para ver se o medico existe//
    }

    @GetMapping
    public List<Medico> retornaTodos(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response AtualizaMedico(@PathVariable Long id, @RequestBody Medico entity){
        
        if(!repository.existsById(id)){
            return new Response(404, "Médico não atualizado"); //O servidor não pode encontrar o recurso solicitado. 
            
        }
        Medico medico = repository.findById(id).get();
        
          if (entity.getNome() != null) {
            medico.setNome(entity.getNome());
        }

          if (entity.getEspecialidade() != null) {
            medico.setEspecialidade(entity.getEspecialidade());
        }
        
         return new Response(204, "Medico atualizado"); // atualiza o médico.
    }


    @DeleteMapping("/{id}")
    public Response deleteMedico(@PathVariable Long id){
        if(!repository.existsById(id)){
            return new Response(404, "Médico não deletado"); //Não vai vir retorno nenhum 
        }
         return new Response(204, "Médico deletado"); // apagou o retorno
    }

}
