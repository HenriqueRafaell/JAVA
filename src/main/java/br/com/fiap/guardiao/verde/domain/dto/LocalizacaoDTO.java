package br.com.fiap.guardiao.verde.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocalizacaoDTO {
	
	@Schema(name = "Nome do local", description = "Nome do local da ocorrência", example = "Floresta Amazônica")
	private String nomeLocal;
	
	@Schema(name = "Latitude do local", description = "Latitude do local da ocorrência", example = "-3.000")
	private double latitude;
	
	@Schema(name = "longitude do local", description = "Longitude do local da ocorrência", example = "-60.000")
	private double longitude;
}
