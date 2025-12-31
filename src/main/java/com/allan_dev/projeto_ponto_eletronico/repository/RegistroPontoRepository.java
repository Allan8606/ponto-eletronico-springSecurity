package com.allan_dev.projeto_ponto_eletronico.repository;

import com.allan_dev.projeto_ponto_eletronico.entity.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {
    List<RegistroPonto> findByFuncionarioNomeContainingIgnoreCase(String nome);
}