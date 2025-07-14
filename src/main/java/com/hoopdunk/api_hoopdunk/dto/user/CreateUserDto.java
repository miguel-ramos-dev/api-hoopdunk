package com.hoopdunk.api_hoopdunk.dto.user;

//Data Transfer Object -> só para transitar dados, guardar só os dados necessários pro cliente ou p banco
public record CreateUserDto(
//        @NotBlank
//        @NotNull
        String nome,
        String nomePerfil,
        String email,
        String senha
) {
}
