package com.allan_dev.projeto_ponto_eletronico.dto.response;

import jakarta.validation.constraints.Email;
import lombok.Builder;



@Builder
public record FuncionarioResponse(
        Long funcionario_id,
        String nome,

        @Email
        String email,
        String perfil) {
}
