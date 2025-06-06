package br.com.fiap.guardiao.verde.domain.dto;

import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatorioDTO {
    @Schema(name = "Alerta", description = "ID do alerta", example = "2")
    private Long alertaId;

    @Schema(name = "Ocorrencia", description = "ID da ocorrência", example = "21")
    private Long ocorrenciaId;

    @Schema(name = "Data", description = "Data do relatório", example = "2025-06-06T18:00:00Z")
    private Date dataRelatorio;

    @Schema(name = "Resumo", description = "Resumo da ocorrência", example = "")
    private String resumo;
}