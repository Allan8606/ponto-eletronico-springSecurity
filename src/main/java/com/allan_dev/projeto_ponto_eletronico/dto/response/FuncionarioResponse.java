package com.allan_dev.projeto_ponto_eletronico.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Builder;



@Builder
public record FuncionarioResponse(
        @Schema(type = "long", description = "ID do funcionario")
        Long funcionario_id,

        @Schema(type = "string", description = "Nome do funcionario")
        String nome,

        @Schema(type = "string", description = "Email do funcionario")
        String email,

        @Schema(type = "string", description = "Perfil do funcionario")
        String perfil) {
}
