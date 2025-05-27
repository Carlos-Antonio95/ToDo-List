package com.carlos.todo_list.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


@Entity // Diz que essa classe é uma entidade do JPA (vira uma tabela)
@Table(name = "tarefas") // Nome da tabela no banco de dados
public class Tarefa {
	
	 @Id // Define o campo como chave primária
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento (para PostgreSQL)
	    private Long id;

	    @Column(nullable = false) // Campo obrigatório
	    private String titulo;

	    private String descricao;

	    @Column(nullable = false)
	    private Boolean concluida = false;

	    private LocalDateTime dataCriacao;
	    
	    @PrePersist
	    protected void onCreate() {
	        this.dataCriacao = LocalDateTime.now();
	    }

	    // Construtor padrão obrigatório para o JPA
	    public Tarefa() {
	    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getConcluida() {
		return concluida;
	}
	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Tarefa(Long id, String titulo, String descricao, Boolean concluida, LocalDateTime dataCriacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.concluida = concluida;
		this.dataCriacao = dataCriacao;
	}
	

}
