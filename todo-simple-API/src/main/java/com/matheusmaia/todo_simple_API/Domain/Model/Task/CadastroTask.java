package com.matheusmaia.todo_simple_API.Domain.Model.Task;

import com.matheusmaia.todo_simple_API.Domain.StatusTarefa;
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
