package it.epicode.validation;

import it.epicode.entities.RoleEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public record UserValidator(
        @NotNull
        @Email
        String email,
        @NotNull
        String password,
        @NotNull
        String username,
        @NotNull
        List<RoleEntity> roles
) {
}
