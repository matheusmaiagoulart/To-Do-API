package com.matheusmaia.todo_simple_API.Model.Task;

public record DadosListagemTasks(Long id, String titulo, String descricao, Status statusTarefa) {

    public DadosListagemTasks(Task task) {
        this(task.getId(), task.getTitulo(), task.getDescricao(), task.getStatus());
    }



}
