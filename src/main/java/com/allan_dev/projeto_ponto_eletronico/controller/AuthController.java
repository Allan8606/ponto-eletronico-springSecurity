package com.allan_dev.projeto_ponto_eletronico.controller;


import com.allan_dev.projeto_ponto_eletronico.dto.request.AuthRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.TokenJWT;
import com.allan_dev.projeto_ponto_eletronico.dto.response.FuncionarioResponse;
import com.allan_dev.projeto_ponto_eletronico.entity.Funcionario;
import com.allan_dev.projeto_ponto_eletronico.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(
        name = "Auth",
        description = "Recurso responsável por fazer o login"
)
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;


    @Operation(
            summary = "Faz o login dos usuários cadastrados.",
            description = "Método responsável por fazer o login dos usuários já cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Login efetuado com sucesso",
            content = @Content(schema = @Schema(implementation = TokenJWT.class))
    )
    @PostMapping
    public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid AuthRequest authRequest){

        UsernamePasswordAuthenticationToken tokenLogin = new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.senha());

        Authentication authenticate = authenticationManager.authenticate(tokenLogin);

        var tokenJWT = tokenService.gerarToken((Funcionario) authenticate.getPrincipal());

        return ResponseEntity.ok(new TokenJWT(tokenJWT));

    }



}
