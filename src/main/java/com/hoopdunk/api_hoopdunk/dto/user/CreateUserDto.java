package com.hoopdunk.api_hoopdunk.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//Data Transfer Object -> só para transitar dados, guardar só os dados necessários pro cliente ou p banco
public record CreateUserDto(

        @NotBlank(message = "Campo nome é obrigatório")
        @Size(min = 3, max = 20, message = "O nome deve ter entre 3 e 45 caracteres")
        String nome,

        @NotBlank(message = "O nome de perfil é obrigatório")
        @Size(min = 5, max = 20, message = "Nome de perfil deve conter no mínimo 5 caracteres!")
        String nomePerfil,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato e-mail inválido")
        @Size(max = 50, message = "E-mail não pode exceder 50 caracteres")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, message = "Senha muito curta")
        String senha
) {
}
