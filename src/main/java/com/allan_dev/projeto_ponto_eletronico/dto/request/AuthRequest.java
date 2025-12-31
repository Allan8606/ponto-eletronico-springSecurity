package com.allan_dev.projeto_ponto_eletronico.dto.request;

import jakarta.validation.constraints.Email;

public record AuthRequest(
        @Email
        String email,
        String senha) {
}
