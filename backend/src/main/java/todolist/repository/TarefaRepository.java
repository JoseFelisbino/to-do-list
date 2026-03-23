package todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todolist.model.Tarefa;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByTituloContainingIgnoreCase(String titulo);
}
