package com.matheusmaia.todo_simple_API.Model.Task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroTaskDTO(
                           @NotBlank
                           String titulo,

                           @NotBlank
                           String descricao,

                           @NotNull
                           Status status) {
}
