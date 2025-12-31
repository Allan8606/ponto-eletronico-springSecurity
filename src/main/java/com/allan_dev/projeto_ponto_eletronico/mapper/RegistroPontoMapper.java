package com.allan_dev.projeto_ponto_eletronico.mapper;


import com.allan_dev.projeto_ponto_eletronico.dto.request.RegistroPontoRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.RegistroPontoResponse;
import com.allan_dev.projeto_ponto_eletronico.entity.RegistroPonto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RegistroPontoMapper {

    public static RegistroPonto paraRegistroPonto(RegistroPontoRequest request){

        return RegistroPonto
                .builder()
                .data(request.data())
                .horaEntrada(request.horaEntrada())
                .horaSaida(request.horaSaida())
                .build();
    }


    public static RegistroPontoResponse paraResponse(RegistroPonto registroPonto){

        return RegistroPontoResponse
                .builder()
                .registroId(registroPonto.getRegistroId())
                .data(registroPonto.getData())
                .horaEntrada(registroPonto.getHoraEntrada())
                .horaSaida(registroPonto.getHoraSaida())
                .funcionarioId(registroPonto.getFuncionario().getFuncionarioId())
                .nomeFuncionario(registroPonto.getFuncionario().getNome())
                .build();
    }


}
