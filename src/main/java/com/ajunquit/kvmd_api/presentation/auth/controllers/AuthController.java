package com.ajunquit.kvmd_api.presentation.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajunquit.kvmd_api.application.auth.dtos.request.LoginRequest;
import com.ajunquit.kvmd_api.application.auth.dtos.request.RegisterRequest;
import com.ajunquit.kvmd_api.application.auth.dtos.responses.LoginResponse;
import com.ajunquit.kvmd_api.application.auth.services.JwtAppService;
import com.ajunquit.kvmd_api.domain.auth.entity.User;
import com.ajunquit.kvmd_api.domain.auth.enums.Role;
import com.ajunquit.kvmd_api.domain.auth.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final UserRepository users;
  private final PasswordEncoder encoder;
  private final AuthenticationManager authManager;
  private final JwtAppService jwt;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest req) {
    if (users.existsByUsername(req.getUsername())) return ResponseEntity.badRequest().body("username taken");
    if (users.existsByEmail(req.getEmail())) return ResponseEntity.badRequest().body("email taken");

    var u = User.builder()
        .username(req.getUsername())
        .email(req.getEmail())
        .password(encoder.encode(req.getPassword()))
        .role(Role.USER)
        .activeRecord(true)
        .build();

    users.save(u);
    return ResponseEntity.ok("registered");
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest req) {
    // autentica credenciales; lanzará excepción si no coincide BCrypt
    authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
    var token = jwt.generateToken(req.getUsername());
    return ResponseEntity.ok(new LoginResponse("sucess", token));
  }
}
