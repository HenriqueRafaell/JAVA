package br.com.fiap.guardiao.verde.domain.mapper;

import br.com.fiap.guardiao.verde.domain.dto.AlertaDTO;
import br.com.fiap.guardiao.verde.domain.entity.Alerta;
import org.springframework.stereotype.Component;

@Component
public class AlertaMapper {

    public Alerta toEntity(AlertaDTO dto) {
        Alerta alerta = new Alerta();
        alerta.setOcorrencia(dto.getOcorrencia());
        alerta.setDataEnvio(dto.getDataEnvio());
        alerta.setPrioridade(dto.getPrioridade());
        return alerta;
    }

    public AlertaDTO toDTO(Alerta entity) {
        AlertaDTO dto = new AlertaDTO();
        dto.setOcorrencia(entity.getOcorrencia());
        dto.setDataEnvio(entity.getDataEnvio());
        dto.setPrioridade(entity.getPrioridade());
        return dto;
    }
}
