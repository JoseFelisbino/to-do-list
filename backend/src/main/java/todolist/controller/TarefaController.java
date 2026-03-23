package todolist.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import todolist.dto.tarefa.TarefaRequest;
import todolist.dto.tarefa.TarefaResponse;
import todolist.service.TarefaService;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public TarefaResponse criar(@Valid @RequestBody TarefaRequest tarefaRequest) {
        return tarefaService.criar(tarefaRequest);
    }

    @GetMapping
    public List<TarefaResponse> listar() {
        return tarefaService.listar();
    }

    @GetMapping("/{id}")
    public TarefaResponse buscarPorID  (@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public TarefaResponse atualizar(@PathVariable Long id, @Valid @RequestBody TarefaRequest tarefaRequest) {
        return tarefaService.atualizar(id, tarefaRequest);

    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }

    @GetMapping("/search")
    public List<TarefaResponse> pequisar(@RequestParam String titulo) {
        return tarefaService.pesquisar(titulo);
    }
}
