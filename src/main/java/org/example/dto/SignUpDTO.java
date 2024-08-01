// src/main/java/org/example/dto/SignUpDTO.java

package org.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public @NotBlank @Size(min = 3, max = 20) String getUsername() {
        return this.username;
    }

    public @NotBlank @Size(max = 50) @Email String getEmail() {
        return this.email;
    }

    public @NotBlank @Size(min = 6, max = 40) String getPassword() {
        return this.password;
    }

    public void setEmail(@NotBlank @Size(max = 50) @Email String email) {
        this.email = email;
    }

    public void setPassword(@NotBlank @Size(min = 6, max = 40) String password) {
        this.password = password;
    }

    public void setUsername(@NotBlank @Size(min = 3, max = 20) String username) {
        this.username = username;
    }
}