package com.devlapa.o_pai_o.domain.usuarios;

public record UsuariosRequestDTO(
        String nome,
        String login,
        String senha,
        String perfil
) { }


