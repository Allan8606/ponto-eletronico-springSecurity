package com.allan_dev.projeto_ponto_eletronico.mapper;

import com.allan_dev.projeto_ponto_eletronico.dto.request.FuncionarioRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.FuncionarioResponse;
import com.allan_dev.projeto_ponto_eletronico.entity.Funcionario;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FuncionarioMapper {


    public static Funcionario paraEntity(FuncionarioRequest funcionarioRequest) {

        return Funcionario
                .builder()
                .nome(funcionarioRequest.nome())
                .email(funcionarioRequest.email())
                .senha(funcionarioRequest.senha())
                .perfil(funcionarioRequest.perfil())
                .build();
    }

    public static FuncionarioResponse paraResponse(Funcionario funcionario){

        return FuncionarioResponse
                .builder()
                .funcionario_id(funcionario.getFuncionarioId())
                .nome(funcionario.getNome())
                .email(funcionario.getEmail())
                .perfil(funcionario.getPerfil().name())
                .build();
    }

}
