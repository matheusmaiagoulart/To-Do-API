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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação para geração dos ID's das tarefas sequenciais
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa statusTarefa;

    public Task(CadastroTask dados){
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.statusTarefa = dados.statusTarefa();
    }


}
