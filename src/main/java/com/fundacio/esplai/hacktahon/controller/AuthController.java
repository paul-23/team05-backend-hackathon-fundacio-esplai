package com.fundacio.esplai.hacktahon.controller;

import com.fundacio.esplai.hacktahon.model.dto.LoginRequest;
import com.fundacio.esplai.hacktahon.model.dto.RegisterRequest;
import com.fundacio.esplai.hacktahon.model.exceptions.EmailAlreadyExistsException;
import com.fundacio.esplai.hacktahon.model.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest request) {

        try {
            userService.register(request);
            return ResponseEntity.ok("User successfully registered.");
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {

        try {
            return ResponseEntity.ok(userService.authenticate(loginRequest));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
