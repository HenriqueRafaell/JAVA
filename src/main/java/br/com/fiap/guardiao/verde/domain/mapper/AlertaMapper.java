package br.com.fiap.guardiao.verde.domain.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.guardiao.verde.domain.dto.AlertaDTO;
import br.com.fiap.guardiao.verde.domain.dto.OcorrenciaIdDTO;
import br.com.fiap.guardiao.verde.domain.entity.Alerta;

@Component
public class AlertaMapper {

    public Alerta toEntity(AlertaDTO dto) {
        Alerta alerta = new Alerta();
        alerta.setDataEnvio(dto.getDataEnvio());
        alerta.setPrioridade(dto.getPrioridade());
        return alerta;
    }

    public AlertaDTO toDTO(Alerta entity) {
        AlertaDTO dto = new AlertaDTO();
        if (entity.getOcorrencia() != null) {
            OcorrenciaIdDTO ocorrenciaIdDTO = new OcorrenciaIdDTO();
            ocorrenciaIdDTO.setId(entity.getOcorrencia().getId());
            dto.setOcorrencia(ocorrenciaIdDTO);
        }
        dto.setDataEnvio(entity.getDataEnvio());
        dto.setPrioridade(entity.getPrioridade());
        return dto;
    }
}
