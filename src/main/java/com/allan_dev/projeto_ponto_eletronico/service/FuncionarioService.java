package com.allan_dev.projeto_ponto_eletronico.service;


import com.allan_dev.projeto_ponto_eletronico.dto.request.FuncionarioRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.FuncionarioResponse;
import com.allan_dev.projeto_ponto_eletronico.entity.Funcionario;
import com.allan_dev.projeto_ponto_eletronico.infra.exception.FuncionarioNaoEncontradoException;
import com.allan_dev.projeto_ponto_eletronico.mapper.FuncionarioMapper;
import com.allan_dev.projeto_ponto_eletronico.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    private final PasswordEncoder passwordEncoder;


    public FuncionarioResponse cadastrar(FuncionarioRequest funcionarioRequest){

        Funcionario funcionario = FuncionarioMapper.paraEntity(funcionarioRequest);
        funcionario.setSenha(criptografarSenha(funcionarioRequest.senha()));
        Funcionario save = funcionarioRepository.save(funcionario);
        return FuncionarioMapper.paraResponse(save);
    }


    public List<FuncionarioResponse> listarTodos(){
        return funcionarioRepository.findAll().stream()
                .map(funcionario -> FuncionarioMapper.paraResponse(funcionario))
                .toList();
    }

    public FuncionarioResponse buscarPorId(Long id){
        Funcionario funcionario = buscarEntidadePorId(id);
        return FuncionarioMapper.paraResponse(funcionario);
    }

    public FuncionarioResponse editar(Long id, FuncionarioRequest funcionarioRequest){

        Funcionario funcionario = buscarEntidadePorId(id);

        funcionario.setNome(funcionarioRequest.nome());
        funcionario.setEmail(funcionarioRequest.email());
        funcionario.setSenha(criptografarSenha(funcionarioRequest.senha()));
        funcionario.setPerfil(funcionarioRequest.perfil());

        return FuncionarioMapper.paraResponse(funcionarioRepository.save(funcionario));

    }

    public void deletar(Long id){
        Funcionario funcionario = buscarEntidadePorId(id);
        funcionarioRepository.delete(funcionario);
    }

    //Métodos auxiliares

    private Funcionario buscarEntidadePorId(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(()-> new FuncionarioNaoEncontradoException(id));
    }

    private String criptografarSenha(String senha){
        return passwordEncoder.encode(senha);
    }



}
