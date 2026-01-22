package com.allan_dev.projeto_ponto_eletronico.dto.request;

import com.allan_dev.projeto_ponto_eletronico.entity.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FuncionarioRequest(
        @NotBlank(message = "O nome é obrigatório e não pode estar em branco")
        String nome,

        @Email(message = "Digite um email válido")
        @NotBlank(message = "O email é obrigatório e não pode estar em branco")
        String email,

        @NotBlank(message = "A senha é obrigatório e não pode estar em branco")
        String senha,

        @NotBlank(message = "O perfil é obrigatório")
        Perfil perfil) {
}
