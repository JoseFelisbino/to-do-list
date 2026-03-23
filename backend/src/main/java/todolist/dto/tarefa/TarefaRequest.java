package todolist.dto.tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import todolist.model.Status;

import java.time.LocalDate;

public record TarefaRequest(

        @NotBlank(message = "O título é obrigatório")
        String titulo,

        String descricao,

        @NotNull(message = "A data de prevista é obrigatória")
        LocalDate dataPrevista,

        @NotNull(message = "O status é obrigatório")
        Status status
) {}
