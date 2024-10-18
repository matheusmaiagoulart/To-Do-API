package com.matheusmaia.todo_simple_API.Model.Task;

public enum Status {
    NAO_INICIADO("Não Iniciado"),
    EM_ANDAMENTO("Em Andamento"),
    FINALIZADO("Finalizado");

    private String valor;

    private Status(String valor){
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
