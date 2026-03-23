package todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todolist.dto.tarefa.TarefaRequest;
import todolist.dto.tarefa.TarefaResponse;
import todolist.exception.ResourceNotFoundException;
import todolist.model.Tarefa;
import todolist.repository.TarefaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    private Tarefa toEntity(TarefaRequest request) {
        return Tarefa.builder()
                .titulo(request.titulo())
                .descricao(request.descricao())
                .dataPrevista(request.dataPrevista())
                .status(request.status())
                .build();
    }

    private TarefaResponse toResponse(Tarefa tarefa) {
        return new TarefaResponse(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getDataPrevista(),
                tarefa.getStatus()
        );
    }

    public TarefaResponse criar(TarefaRequest request) {
        Tarefa tarefa = toEntity(request);
        return toResponse(tarefaRepository.save(tarefa));
    }

    public List<TarefaResponse> listar() {
        return tarefaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TarefaResponse buscarPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));

        return toResponse(tarefa);
    }

    public TarefaResponse atualizar(Long id, TarefaRequest request) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));

        tarefa.setTitulo(request.titulo());
        tarefa.setDescricao(request.descricao());
        tarefa.setDataPrevista(request.dataPrevista());
        tarefa.setStatus(request.status());

        return toResponse(tarefaRepository.save(tarefa));
    }

    public void deletar(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada");
        }

        tarefaRepository.deleteById(id);
    }

    public List<TarefaResponse> pesquisar(String titulo) {
        return tarefaRepository.findByTituloContainingIgnoreCase(titulo)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}


