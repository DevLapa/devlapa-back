package com.devlapa.o_pai_o.domain.usuarios;

import java.time.LocalDateTime;

public record UsuariosResponseDTO(
        Long id,
        String nome,
        String login,
        String perfil,
        Boolean ativo,
        LocalDateTime dataCadastro
) {}