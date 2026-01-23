package com.allan_dev.projeto_ponto_eletronico.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record RegistroPontoResponse(
        @Schema(type = "long", description = "ID do registro do ponto")
        Long registroId,

        @Schema(type = "string", format = "date", description = "Data em que o funcionário registrou o ponto", example = "30/12/2025")
        LocalDate data,

        @Schema(type = "string", format = "date", description = "Horario em que o funcionário registrou sua entrada", example = "22:15")
        LocalTime horaEntrada,

        @Schema(type = "string", format = "date", description = "Horario em que o funcionário registrou sua entrada", example = "22:15")
        LocalTime horaSaida,

        @Schema(type = "long", description = "ID do funcionário, no qual se refere as informações que foam cadastradas")
        Long funcionarioId,

        @Schema(type = "string", description = "Nome do funcionário que registrou o ponto")
        String nomeFuncionario
) {
}
