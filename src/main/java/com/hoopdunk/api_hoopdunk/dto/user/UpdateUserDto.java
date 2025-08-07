package com.hoopdunk.api_hoopdunk.dto.user;

import jakarta.validation.constraints.NotEmpty;

public record UpdateUserDto(
        String nome,
        String nomePerfil,
        String email,
        String senha,
        @NotEmpty
        String posicao,
        @NotEmpty //not null + not blank juntos
        String nivel
//        String foto
) {}
