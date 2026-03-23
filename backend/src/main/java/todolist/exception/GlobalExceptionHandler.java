package todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 404);
        erro.put("error", "Recurso não encontrado");
        erro.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 400);
        erro.put("erro", "Erro de validação");

        Map<String, String> campos = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(e ->
                campos.put(e.getField(), e.getDefaultMessage())
        );

        erro.put("mensagens", campos);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
