package br.com.cineflix.controller;

import br.com.cineflix.controller.request.LoginRequest;
import br.com.cineflix.controller.request.UserRequest;
import br.com.cineflix.controller.response.UserResponse;
import br.com.cineflix.entity.User;
import br.com.cineflix.mapper.UserMapper;
import br.com.cineflix.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cineflix/auth")
public class AuthController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        User savedUser = service.saveUser(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        User user = (User) authenticate.getPrincipal();

        //
    }
}
