package com.matheusmaia.todo_simple_API.Model.Task;

public record DadosListagemTasksDTO(Long id, String titulo, String descricao, Status status) {

    public DadosListagemTasksDTO(Task task) {
        this(task.getId(), task.getTitulo(), task.getDescricao(), task.getStatus());
    }



}
