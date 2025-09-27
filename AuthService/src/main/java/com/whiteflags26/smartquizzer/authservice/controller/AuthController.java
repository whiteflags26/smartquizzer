package com.whiteflags26.smartquizzer.auth.controller;

import com.whiteflags26.smartquizzer.auth.dto.UserDto;
import com.whiteflags26.smartquizzer.auth.enums.UserRole;
import com.whiteflags26.smartquizzer.auth.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getLogin(@RequestBody UserDto userDto) {
        return authenticationService.login(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<?> postRegister(@RequestBody UserDto userDto) {
        return authenticationService.register(userDto, UserRole.USER);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> isValidJwt(@RequestParam String token) {
        return authenticationService.isValidJwt(token);
    }
}