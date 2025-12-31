package com.allan_dev.projeto_ponto_eletronico.dto.request;

import com.allan_dev.projeto_ponto_eletronico.entity.Perfil;
import jakarta.validation.constraints.Email;

public record FuncionarioRequest(
        String nome,

        @Email
        String email,
        String senha,
        Perfil perfil) {
}
