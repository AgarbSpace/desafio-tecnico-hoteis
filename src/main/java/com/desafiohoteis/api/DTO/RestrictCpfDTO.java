package com.desafiohoteis.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record RestrictCpfDTO(@NotBlank String cpf) {
    
}
