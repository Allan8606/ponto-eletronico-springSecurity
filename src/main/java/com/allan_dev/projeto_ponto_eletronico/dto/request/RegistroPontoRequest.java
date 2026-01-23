package com.allan_dev.projeto_ponto_eletronico.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalTime;

public record RegistroPontoRequest(
        @Schema(type = "string", format = "date", description = "Data em que o funcionário registrou o ponto", example = "30/12/2025")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate data,

        @Schema(type = "string", format = "date", description = "Horario em que o funcionário registrou sua entrada", example = "22:15")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        LocalTime horaEntrada,

        @Schema(type = "string", format = "time", description = "Horario em que o funcionário registrou sua saída", example = "06:15")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        LocalTime horaSaida,

        @Schema(type = "long", description = "ID do funcionário, no qual se refere as informações que foam cadastradas")
        Long funcionarioId
) {
}
