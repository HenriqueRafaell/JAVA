package br.com.fiap.guardiao.verde.domain.dto;

import java.util.Date;

import br.com.fiap.guardiao.verde.domain.entity.Localizacao;
import br.com.fiap.guardiao.verde.domain.enums.StatusOcorrencia;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaDTO {

	@Schema(name = "Data", description = "Data da ocorrencia", example = "12/12/12")
	private Date dataOcorrencia;
	
	@Schema(name = "Status", description = "Status da ocorrencia", example = "Em análise")
	private StatusOcorrencia status;

	@Schema(name = "Localizacao", description = "Localizacao da ocorrencia", example = "")
	private LocalizacaoIdDTO localizacao;

}
