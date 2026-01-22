package com.allan_dev.projeto_ponto_eletronico.infra.exception;

import com.allan_dev.projeto_ponto_eletronico.dto.ErroResponse;
import com.allan_dev.projeto_ponto_eletronico.dto.ErroValidacaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FuncionarioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleFuncionarioNaoEncontrado(
            FuncionarioNaoEncontradoException ex) {

        ErroResponse erro = new ErroResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoResponse>> handleValidacao(
            MethodArgumentNotValidException ex) {

        List<ErroValidacaoResponse> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new ErroValidacaoResponse(
                        erro.getField(),
                        erro.getDefaultMessage()
                ))
                .toList();

        return ResponseEntity.badRequest().body(erros);
    }
}

