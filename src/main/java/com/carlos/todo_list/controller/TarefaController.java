package com.carlos.todo_list.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.todo_list.model.Tarefa;
import com.carlos.todo_list.service.TarefaService;


@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaService.salvar(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
       String mensagem = tarefaService.deletar(id);
       return ResponseEntity.ok(mensagem);
        //return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Tarefa> atualizarStatus(@PathVariable Long id) {
        Tarefa tarefaAtualizada = tarefaService.definirStatus(id);

        if (tarefaAtualizada != null) {
            return ResponseEntity.ok(tarefaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa);

        if (tarefaAtualizada != null) {
            return ResponseEntity.ok(tarefaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
