package com.fundacio.esplai.hacktahon.model.service;

import com.fundacio.esplai.hacktahon.model.domain.Role;
import com.fundacio.esplai.hacktahon.model.domain.User;
import com.fundacio.esplai.hacktahon.model.dto.JwtResponse;
import com.fundacio.esplai.hacktahon.model.dto.LoginRequest;
import com.fundacio.esplai.hacktahon.model.dto.RegisterRequest;
import com.fundacio.esplai.hacktahon.model.exceptions.BadCredentialsException;
import com.fundacio.esplai.hacktahon.model.exceptions.EmailAlreadyExistsException;
import com.fundacio.esplai.hacktahon.model.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final String BAD_CREDENTIALS = "Invalid username/password";


    public void register(RegisterRequest request) {
        Optional<User> userOptional = userRepo.findByEmail(request.getEmail());

        if (userOptional.isPresent()) {
            throw new EmailAlreadyExistsException("This email is already registered.");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepo.save(user);
    }

    public JwtResponse authenticate(LoginRequest request) throws AuthenticationException {
        User user;
        Optional<User> userOptional = userRepo.findByEmail(request.getEmail());

        if (userOptional.isPresent()) {
            user = userOptional.get();
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new BadCredentialsException(BAD_CREDENTIALS);
            }
        } else {
            throw new BadCredentialsException(BAD_CREDENTIALS);
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(BAD_CREDENTIALS);
        }

        String jwtToken = jwtService.generateToken(user);

        return JwtResponse.builder()
                .token(jwtToken)
                .build();
    }

}
