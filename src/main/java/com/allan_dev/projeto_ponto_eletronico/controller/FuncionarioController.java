package com.allan_dev.projeto_ponto_eletronico.controller;


import com.allan_dev.projeto_ponto_eletronico.dto.request.FuncionarioRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.FuncionarioResponse;
import com.allan_dev.projeto_ponto_eletronico.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;


    @PostMapping
    public ResponseEntity<FuncionarioResponse> cadastrar(@RequestBody FuncionarioRequest request){
        FuncionarioResponse cadastrar = service.cadastrar(request);
        return ResponseEntity.ok(cadastrar);

    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> editar(@PathVariable Long id, @RequestBody FuncionarioRequest request){
        return ResponseEntity.ok(service.editar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }





}
