package com.carlos.todo_list.exception;

public class TarefaNaoEncontradaException extends RuntimeException {

    public TarefaNaoEncontradaException(Long id) {
        super("Tarefa com ID " + id + " não foi encontrada.");
    }
}