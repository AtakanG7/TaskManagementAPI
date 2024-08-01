// src/main/java/org/example/dto/LoginDTO.java

package org.example.dto;

import javax.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }

    public void setUsernameOrEmail(@NotBlank String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public @NotBlank String getUsernameOrEmail() {
        return usernameOrEmail;
    }
}