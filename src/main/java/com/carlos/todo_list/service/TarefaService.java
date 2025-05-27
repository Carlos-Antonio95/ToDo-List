package com.carlos.todo_list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carlos.todo_list.exception.TarefaNaoEncontradaException;
import com.carlos.todo_list.model.Tarefa;
import com.carlos.todo_list.repository.TarefaRepository;

@Service
public class TarefaService {

	private  TarefaRepository tarefaRepository;
	

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
	
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    
    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaExistenteOptional = tarefaRepository.findById(id);	

        if (tarefaExistenteOptional.isPresent()) {
            Tarefa tarefaExistente = tarefaExistenteOptional.get();
            tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
            tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());

            return tarefaRepository.save(tarefaExistente);
        } else {
           throw new TarefaNaoEncontradaException(id);
        }
    }


    public Tarefa definirStatus(Long id) {
    	Optional<Tarefa> tarefaExistenteOptional = tarefaRepository.findById(id);
    	
    	if (tarefaExistenteOptional.isPresent()) {
			Tarefa tarefaExistente = tarefaExistenteOptional.get();
			if (tarefaExistente.getConcluida()) {
				tarefaExistente.setConcluida(false);
			} else {
				tarefaExistente.setConcluida(true);
			}
			return tarefaRepository.save(tarefaExistente);
			
		} else {
			return null;
		}
    }
    
    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public String deletar(Long id) {
        tarefaRepository.deleteById(id);
        return "tarefa com " +id+" deleatada";
    }

	
}
