package com.devlapa.o_pai_o.mapper;

import com.devlapa.o_pai_o.domain.usuarios.UsuarioResumoDTO;
import com.devlapa.o_pai_o.domain.usuarios.Usuarios;

public class UsuarioMapper {
    public static UsuarioResumoDTO toDTO(Usuarios usuarios){
        return new UsuarioResumoDTO(
                usuarios.getId(),
                usuarios.getNome(),
                usuarios.getPerfil()
        );
    }
}
