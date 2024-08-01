// src/main/java/org/example/service/AuthService.java

package org.example.service;

import org.example.dto.AuthResponseDTO;
import org.example.dto.LoginDTO;
import org.example.dto.SignUpDTO;

public interface AuthService {
    void registerUser(SignUpDTO signUpDto);
    AuthResponseDTO authenticateUser(LoginDTO loginDto);
}