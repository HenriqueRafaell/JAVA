package br.com.fiap.guardiao.verde.domain.dto;

import br.com.fiap.guardiao.verde.domain.enums.TipoUsuario;
import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioDTO {
	
	@Schema(name = "Nome", description = "Nome do usuario", example = "Henrique Rafael")
	private String nome;
	
	@Schema(name = "Tipo do Usuario", description = "Tipo do usuario cadastrado", example = "MORADOR")
	private TipoUsuario tipoUsuario;
	
	@Schema(name = "E-mail", description = "E-mail do usuario", example = "Henrique.Rafael@fiap.com.br")
	private String email;
	
	@Schema(name = "Senha", description = "SENHA do usuario", example = "12345678")
	private String senha;
}
