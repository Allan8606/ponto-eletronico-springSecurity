package com.allan_dev.projeto_ponto_eletronico.controller;


import com.allan_dev.projeto_ponto_eletronico.dto.request.FuncionarioRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.response.FuncionarioResponse;
import com.allan_dev.projeto_ponto_eletronico.service.FuncionarioService;
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
        name = "Funcionario",
        description = "Recurso responsável pelo gerenciamento dos funcionarios"
)
@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;


    @Operation(
            summary = "Cadastra um novo funcionario.",
            description = "Método responsável por cadastrar um novo funcionario.",
            security = @SecurityRequirement(name = "bearAuth")
    )
    @ApiResponse(
            responseCode = "201",
            description = "Funcionário cadastrado com sucesso",
            content = @Content(schema = @Schema(implementation = FuncionarioResponse.class))
    )
    @PostMapping
    public ResponseEntity<FuncionarioResponse> cadastrar(@Valid @RequestBody FuncionarioRequest request){
        FuncionarioResponse cadastrar = service.cadastrar(request);
        return ResponseEntity.ok(cadastrar);

    }

    @Operation(
            summary = "Lista todos os funcionarios cadastrados.",
            description = "Método responsável por listar todos os funcionarios.",
            security = @SecurityRequirement(name = "bearAuth")
    )
    @ApiResponse(
            responseCode = "200",
            description = "Retorna todos os funcionários cadastrados",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FuncionarioResponse.class)))
    )
    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }



    @Operation(
            summary = "Busca um funcionario cadastrado pelo seu ID.",
            description = "Método responsável por buscar um funcionário pelo seu ID.",
            security = @SecurityRequirement(name = "bearAuth")
    )
    @ApiResponse(
            responseCode = "200",
            description = "Funcionário encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = FuncionarioResponse.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Funcionário não encontrado",
            content = @Content()
    )
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }



    @Operation(
            summary = "Edita um funcionario já cadastrado.",
            description = "Método responsável por editar um funcionário cadastrado, usando o seu ID.",
            security = @SecurityRequirement(name = "bearAuth")
    )
    @ApiResponse(
            responseCode = "200",
            description = "Funcionário encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = FuncionarioResponse.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Funcionário não encontrado",
            content = @Content()
    )
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> editar(@PathVariable Long id, @Valid @RequestBody FuncionarioRequest request){
        return ResponseEntity.ok(service.editar(id, request));
    }


    @Operation(
            summary = "Deleta funcionário pelo seu ID.",
            description = "Método responsável por deletar um funcionário pelo seu ID.",
            security = @SecurityRequirement(name = "bearAuth")
    )
    @ApiResponse(
            responseCode = "201",
            description = "Funcionário encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = FuncionarioResponse.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Funcionário não encontrado",
            content = @Content()
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
