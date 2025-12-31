package com.allan_dev.projeto_ponto_eletronico.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record RegistroPontoResponse(
        Long registroId,
        LocalDate data,
        LocalTime horaEntrada,
        LocalTime horaSaida,
        Long funcionarioId,
        String nomeFuncionario
) {
}
