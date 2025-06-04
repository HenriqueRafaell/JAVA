package br.com.fiap.guardiao.verde.domain.mapper;

import br.com.fiap.guardiao.verde.domain.dto.AlertaDTO;
import br.com.fiap.guardiao.verde.domain.entity.Alerta;
import br.com.fiap.guardiao.verde.domain.entity.Ocorrencia;

public class AlertaMapper {
	
	public static AlertaDTO toDTO(Alerta alerta) {
		AlertaDTO dto = new AlertaDTO();
		dto.setOcorrencia(alerta.getOcorrencia().getId());
		dto.setDataEnvio(alerta.getDataEnvio());
		dto.setPrioridade(alerta.getPrioridade());
		
		return dto;
	}
	
	public static AlertaDTO toEntity(Alerta alerta, Ocorrencia ocorrencia) {
		Alerta alerta = new Alerta();
		alerta.setOcorrencia(ocorrencia);
		alerta.setDataEnvio();
	}
}
