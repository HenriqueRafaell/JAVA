package br.com.fiap.guardiao.verde.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    @Schema(name = "Nome", description = "Nome do usuario", example = "Henrique Rafael")
    private String nome;

    @Schema(name = "Tipo do Usuario", description = "ID do tipo do usuario", example = "1")
    private Long tipoUsuarioId; 

    @Schema(name = "E-mail", description = "E-mail do usuario", example = "Henrique.Rafael@fiap.com.br")
    private String email;

    @Schema(name = "Senha", description = "SENHA do usuario", example = "12345678")
    private String senha;
}