package com.devlapa.o_pai_o.mapper;

import com.devlapa.o_pai_o.domain.usuarios.UsuarioResumoDTO;
import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import com.devlapa.o_pai_o.domain.vendas.Vendas;
import com.devlapa.o_pai_o.domain.vendas.VendasResponseDTO;

public class VendasMapper {
    public static VendasResponseDTO toDTO(Vendas vendas){
        Usuarios usuarios = vendas.getUsuarioCriacao();

        UsuarioResumoDTO usuarioResumoDTO = new UsuarioResumoDTO(
                usuarios.getId(),
                usuarios.getNome(),
                usuarios.getPerfil()
        );

        return  new VendasResponseDTO(
                vendas.getId(),
                vendas.getFormasPagamentos(),
                vendas.getItens(),
                vendas.getValor_total(),
                vendas.getStatus(),
                vendas.getData_criacao(),
                usuarioResumoDTO
        );
    }
}
