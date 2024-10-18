package com.matheusmaia.todo_simple_API.Model.Task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroTask(

                           @NotBlank
                           String titulo,

                           @NotBlank
                           String descricao,

                           @NotNull
                           StatusTarefa statusTarefa) {
}
