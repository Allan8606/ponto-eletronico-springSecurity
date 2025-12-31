package com.allan_dev.projeto_ponto_eletronico.service;


import com.allan_dev.projeto_ponto_eletronico.dto.request.FuncionarioRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.FuncionarioResponse;
import com.allan_dev.projeto_ponto_eletronico.entity.Funcionario;
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
        funcionario.setSenha(criptografarSenha(funcionarioRequest));
        funcionarioRepository.save(funcionario);
        return FuncionarioMapper.paraResponse(funcionario);
    }

    public String criptografarSenha(FuncionarioRequest request){
        String senhaCriptografada = passwordEncoder.encode(request.senha());
        return senhaCriptografada;
    }

    public List<FuncionarioResponse> listarTodos(){
        return funcionarioRepository.findAll().stream()
                .map(funcionario -> FuncionarioMapper.paraResponse(funcionario))
                .toList();
    }

    public FuncionarioResponse buscarPorId(Long id){
       return funcionarioRepository.findById(id).map(FuncionarioMapper::paraResponse).orElseThrow(EntityNotFoundException::new);

    }

    public FuncionarioResponse editar(Long id, FuncionarioRequest funcionarioRequest){

        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        funcionario.setNome(funcionarioRequest.nome());
        funcionario.setEmail(funcionarioRequest.email());
        funcionario.setSenha(criptografarSenha(funcionarioRequest));
        funcionario.setPerfil(funcionarioRequest.perfil());

        funcionarioRepository.save(funcionario);
        return FuncionarioMapper.paraResponse(funcionario);

    }

    public void deletar(Long id){
        funcionarioRepository.findById(id).ifPresent(funcionarioRepository::delete);
    }



}
