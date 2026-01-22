package com.allan_dev.projeto_ponto_eletronico.infra.exception;

public class FuncionarioNaoEncontradoException extends RuntimeException {

    public FuncionarioNaoEncontradoException(Long id) {
        super("Funcionário não encontrado com id: " + id);
    }
}

