package com.allan_dev.projeto_ponto_eletronico.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public record AuthRequest(
        @Schema(type = "string", description = "Email utilizado para fazer o login. Mesmo email que foi cadastrado")
        @Email(message = "Digite um email valido")
        String email,

        @Schema(type = "string", description = "Senha utilizado para fazer o login. Mesma senha que foi feito no cadastro")
        String senha) {
}
