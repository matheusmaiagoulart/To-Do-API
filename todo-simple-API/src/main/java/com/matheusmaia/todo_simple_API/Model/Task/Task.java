package com.matheusmaia.todo_simple_API.Model.Task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "Task")
@Table(name = "Tasks")
public class Task {


    //Criacao de atributos necessarios da Entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação para geração dos ID's das tarefas sequenciais
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;


    //Construtor para criacao de uma task que espera um DTO por parametro
    public Task(CadastroTask dados){
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.status = dados.status();
    }

    public void atualizarInformacoes(UpdateTask dados){

        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if(dados.status() != null){
            this.status = dados.status();
        }
    }
    }



