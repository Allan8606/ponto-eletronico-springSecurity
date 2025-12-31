package com.allan_dev.projeto_ponto_eletronico.repository;

import com.allan_dev.projeto_ponto_eletronico.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    Optional<Funcionario> findByEmail(String username);
}