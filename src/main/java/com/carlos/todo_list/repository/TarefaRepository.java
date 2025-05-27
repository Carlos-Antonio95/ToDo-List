package com.carlos.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.todo_list.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	

}
