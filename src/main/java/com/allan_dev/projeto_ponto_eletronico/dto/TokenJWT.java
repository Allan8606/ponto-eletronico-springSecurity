package com.allan_dev.projeto_ponto_eletronico.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record TokenJWT(
        @Schema(type = "string",
        description = "Token responsável por da permissão aos usuários cadastrados",
        example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0Ijs0NTE2MjM5MDB9.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c")
        String token) {
}
