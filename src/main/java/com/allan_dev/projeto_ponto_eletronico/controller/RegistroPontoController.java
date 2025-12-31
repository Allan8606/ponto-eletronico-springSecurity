package com.allan_dev.projeto_ponto_eletronico.controller;


import com.allan_dev.projeto_ponto_eletronico.dto.request.RegistroPontoRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.RegistroPontoResponse;
import com.allan_dev.projeto_ponto_eletronico.service.RegistroPontoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registroPonto")
@RequiredArgsConstructor
public class RegistroPontoController {

    private final RegistroPontoService service;

    @PostMapping
    public ResponseEntity<RegistroPontoResponse> registrar(@RequestBody RegistroPontoRequest request) {
        return ResponseEntity.ok(service.registrar(request));
    }

    @GetMapping
    public ResponseEntity<List<RegistroPontoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/funcionario")
    public ResponseEntity<List<RegistroPontoResponse>> buscarPorFuncionario(@RequestParam String nome){
        return ResponseEntity.ok(service.buscarPorFuncionario(nome));

    }


    @PutMapping("/{id}")
    public ResponseEntity<RegistroPontoResponse> editar(@PathVariable Long id, @RequestBody RegistroPontoRequest request){
        return ResponseEntity.ok(service.editar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
