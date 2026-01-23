package com.allan_dev.projeto_ponto_eletronico.dto.request;

import com.allan_dev.projeto_ponto_eletronico.entity.Perfil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioRequest(
        @Schema(type = "string", description = "Nome do funcionario")
        @NotBlank(message = "O nome é obrigatório e não pode estar em branco")
        String nome,

        @Schema(type = "string", description = "Email do funcionario")
        @Email(message = "Digite um email válido")
        @NotBlank(message = "O email é obrigatório e não pode estar em branco")
        String email,

        @Schema(type = "string", description = "Senha do funcionario")
        @NotBlank(message = "A senha é obrigatório e não pode estar em branco")
        String senha,

        @Schema( description = "Perfil do funcionário",
                example = "ADMIN",
                allowableValues = {"ADMIN", "USER"})
        @NotNull(message = "O perfil é obrigatório")
        Perfil perfil) {
}
