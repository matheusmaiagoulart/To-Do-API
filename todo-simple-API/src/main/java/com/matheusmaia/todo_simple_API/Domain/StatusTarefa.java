package com.matheusmaia.todo_simple_API.Domain;

public enum StatusTarefa {
    NAO_INICIADO("Não Iniciado"),
    EM_ANDAMENTO("Em Andamento"),
    FINALIZADO("Concluído");

    private String statusTarefa;

    StatusTarefa(String s) {
        this.statusTarefa = s;
    }
}
