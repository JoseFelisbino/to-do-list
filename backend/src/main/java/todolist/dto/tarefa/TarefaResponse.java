package todolist.dto.tarefa;

public record TarefaResponse(
        Long id,
        String titulo,
        String descricao,
        String dataPrevista,
        String status
) {}
