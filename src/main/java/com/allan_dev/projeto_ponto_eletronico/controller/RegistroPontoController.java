package com.allan_dev.projeto_ponto_eletronico.controller;


import com.allan_dev.projeto_ponto_eletronico.dto.request.RegistroPontoRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.FuncionarioResponse;
import com.allan_dev.projeto_ponto_eletronico.dto.response.RegistroPontoResponse;
import com.allan_dev.projeto_ponto_eletronico.service.RegistroPontoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "Registro dos pontos eletronicos",
        description = "Recurso responsável pelo gerenciamento dos pontos eletronicos"
)
@RestController
@RequestMapping("/registroPonto")
@RequiredArgsConstructor
public class RegistroPontoController {

    private final RegistroPontoService service;

    @Operation(summary = "Registra um novo ponto eletronico.",
            description = "Método responsável por cadastrar um novo ponto eletronico.",
            security = @SecurityRequirement(name = "bearAuth"))
    @ApiResponse(responseCode = "201",
            description = "Ponto eletronico cadastrado com sucesso",
            content = @Content(schema = @Schema(implementation = RegistroPontoResponse.class)))
    @PostMapping
    public ResponseEntity<RegistroPontoResponse> registrar(@Valid @RequestBody RegistroPontoRequest request) {
        return ResponseEntity.ok(service.registrar(request));
    }


    @Operation(summary = "Lista os registros de ponto eletronico",
            description = "Método responsável por listar todos os pontos eletronicos cadastrados.",
            security = @SecurityRequirement(name = "bearAuth"))
    @ApiResponse(responseCode = "200",
            description = "Retorna todos os pontos eletronicos",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = RegistroPontoResponse.class))))
    @GetMapping
    public ResponseEntity<List<RegistroPontoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Busca o registro pelo nome do funcionário.",
            description = "Método responsável por buscar os registros de ponto eletronico, pelo nome do funcionário.",
            security = @SecurityRequirement(name = "bearAuth"))
    @ApiResponse(responseCode = "200",
            description = "Ponto eletronico encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = RegistroPontoResponse.class)))
    @ApiResponse(responseCode = "404",
            description = "Ponto eletronico não encontrado",
            content = @Content())
    @GetMapping("/funcionario")
    public ResponseEntity<List<RegistroPontoResponse>> buscarPorFuncionario(@RequestParam String nome){
        return ResponseEntity.ok(service.buscarPorFuncionario(nome));
    }


    @Operation(summary = "Edita um ponto eletronico.",
            description = "Método responsável por editar um ponto eletronico já cadastrado pelo seu ID.",
            security = @SecurityRequirement(name = "bearAuth"))
    @ApiResponse(responseCode = "200",
            description = "Ponto eletronico encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = RegistroPontoResponse.class)))
    @ApiResponse(responseCode = "404",
            description = "Ponto eletronico não encontrado",
            content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<RegistroPontoResponse> editar(@PathVariable Long id, @Valid @RequestBody RegistroPontoRequest request){
        return ResponseEntity.ok(service.editar(id, request));
    }


    @Operation(summary = "Deleta um ponto eletronico.",
            description = "Método responsável por deletar um ponto eletronico já cadastrado pelo seu ID.",
            security = @SecurityRequirement(name = "bearAuth"))
    @ApiResponse(responseCode = "200",
            description = "Ponto eletronico encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = RegistroPontoResponse.class)))
    @ApiResponse(responseCode = "404",
            description = "Ponto eletronico não encontrado",
            content = @Content())
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
