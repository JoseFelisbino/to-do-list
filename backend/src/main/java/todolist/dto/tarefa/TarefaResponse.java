package todolist.dto.tarefa;

import todolist.model.Status;

import java.time.LocalDate;

public record TarefaResponse(
        Long id,
        String titulo,
        String descricao,
        LocalDate dataPrevista,
        Status status
) {}
