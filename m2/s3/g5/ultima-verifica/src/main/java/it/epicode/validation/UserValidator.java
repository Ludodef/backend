package it.epicode.validation;

import it.epicode.entities.RoleEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public record UserValidator(
        @NotNull
        @Email
        String email,
        @NotNull
                @NotBlank
        String password,
        @NotNull
                @NotBlank
        String username,

        List<RoleEntity> roles
) {
}
