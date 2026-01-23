package com.allan_dev.projeto_ponto_eletronico.service;


import com.allan_dev.projeto_ponto_eletronico.dto.request.FuncionarioRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.request.RegistroPontoRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.FuncionarioResponse;
import com.allan_dev.projeto_ponto_eletronico.dto.response.RegistroPontoResponse;
import com.allan_dev.projeto_ponto_eletronico.entity.Funcionario;
import com.allan_dev.projeto_ponto_eletronico.entity.RegistroPonto;
import com.allan_dev.projeto_ponto_eletronico.infra.exception.FuncionarioNaoEncontradoException;
import com.allan_dev.projeto_ponto_eletronico.infra.exception.RegistroNaoEncontradoException;
import com.allan_dev.projeto_ponto_eletronico.mapper.FuncionarioMapper;
import com.allan_dev.projeto_ponto_eletronico.mapper.RegistroPontoMapper;
import com.allan_dev.projeto_ponto_eletronico.repository.FuncionarioRepository;
import com.allan_dev.projeto_ponto_eletronico.repository.RegistroPontoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistroPontoService {

    private final RegistroPontoRepository registroPontoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public RegistroPontoResponse registrar(RegistroPontoRequest request){
        var funcionario = funcionarioRepository.findById(request.funcionarioId()).orElseThrow(() ->
                new FuncionarioNaoEncontradoException(request.funcionarioId()));

        RegistroPonto registroPonto = RegistroPontoMapper.paraRegistroPonto(request);

        registroPonto.setFuncionario(funcionario);

        registroPontoRepository.save(registroPonto);

        return RegistroPontoMapper.paraResponse(registroPonto);
    }

    public List<RegistroPontoResponse> listarTodos(){
        return registroPontoRepository.findAll()
                .stream()
                .map(RegistroPontoMapper::paraResponse)
                .toList();
    }

    public List<RegistroPontoResponse> buscarPorFuncionario(String nome){

        return registroPontoRepository.findByFuncionarioNomeContainingIgnoreCase(nome)
                .stream()
                .map(RegistroPontoMapper::paraResponse)
                .toList();
    }



    public RegistroPontoResponse editar(Long registro_id, RegistroPontoRequest request){
        RegistroPonto registroPonto = buscarEntidadePorId(registro_id);

        registroPonto.setData(request.data());
        registroPonto.setHoraEntrada(request.horaEntrada());
        registroPonto.setHoraSaida(request.horaSaida());

        registroPontoRepository.save(registroPonto);

        return RegistroPontoMapper.paraResponse(registroPonto);
    }

    public void deletar(Long id){
        registroPontoRepository.findById(id).ifPresent(registroPontoRepository::delete);

    }



    private RegistroPonto buscarEntidadePorId(Long id){
        return registroPontoRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException(id));
    }
}
