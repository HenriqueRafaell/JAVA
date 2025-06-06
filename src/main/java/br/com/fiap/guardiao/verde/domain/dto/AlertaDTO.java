package br.com.fiap.guardiao.verde.domain.dto;

import java.util.Date;

import br.com.fiap.guardiao.verde.domain.entity.Ocorrencia;
import br.com.fiap.guardiao.verde.domain.enums.PrioridadeAlerta;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlertaDTO { 
	
	@Schema(name = "Ocorrencia", description = "Ocorrencia", example = "12/12/12")
	private OcorrenciaIdDTO ocorrencia;
	
	@Schema(name = "Data", description = "Data de envio do Alerta", example = "12/12/12")
	private Date dataEnvio;
	
	@Schema(name = "Prioridade", description = "Prioridade do alerta", example = "BAIXA")
	private PrioridadeAlerta prioridade;
}