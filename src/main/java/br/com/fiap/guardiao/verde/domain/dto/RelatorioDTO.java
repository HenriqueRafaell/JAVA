package br.com.fiap.guardiao.verde.domain.dto;

import java.util.Date;

import br.com.fiap.guardiao.verde.domain.entity.Alerta;
import br.com.fiap.guardiao.verde.domain.entity.Ocorrencia;
import io.swagger.v3.oas.annotations.media.Schema;

public class RelatorioDTO {
	
	@Schema(name = "Alerta", description = "Alerta", example = "12/12/12")
	private Alerta alerta;
	
	@Schema(name = "Ocorrencia", description = "Ocorrencia", example = "12/12/12")
	private Ocorrencia ocorrencia;
	
	@Schema(name = "Data", description = "Data da ocorrencia", example = "12/12/12")
	private Date dataRelatorio;
	
	@Schema(name = "Resumo", description = "Resumo da ocorrencia", example = "")
	private String resumo;
}
