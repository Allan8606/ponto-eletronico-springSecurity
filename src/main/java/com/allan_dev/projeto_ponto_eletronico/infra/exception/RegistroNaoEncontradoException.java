package com.allan_dev.projeto_ponto_eletronico.infra.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(Long id) {
        super("Registro não encontrado com id: " + id);
    }

    public RegistroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

