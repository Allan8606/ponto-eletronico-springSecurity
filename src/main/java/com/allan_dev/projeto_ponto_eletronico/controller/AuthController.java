package com.allan_dev.projeto_ponto_eletronico.controller;


import com.allan_dev.projeto_ponto_eletronico.dto.request.AuthRequest;
import com.allan_dev.projeto_ponto_eletronico.dto.TokenJWT;
import com.allan_dev.projeto_ponto_eletronico.entity.Funcionario;
import com.allan_dev.projeto_ponto_eletronico.security.TokenService;
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

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid AuthRequest authRequest){

        UsernamePasswordAuthenticationToken tokenLogin = new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.senha());

        Authentication authenticate = authenticationManager.authenticate(tokenLogin);

        var tokenJWT = tokenService.gerarToken((Funcionario) authenticate.getPrincipal());

        return ResponseEntity.ok(new TokenJWT(tokenJWT));

    }



}
