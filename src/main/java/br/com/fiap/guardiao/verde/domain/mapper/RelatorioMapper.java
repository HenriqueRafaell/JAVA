package br.com.fiap.guardiao.verde.domain.mapper;

import br.com.fiap.guardiao.verde.domain.dto.RelatorioDTO;
import br.com.fiap.guardiao.verde.domain.entity.Relatorio;
import org.springframework.stereotype.Component;

@Component
public class RelatorioMapper {

    public Relatorio toEntity(RelatorioDTO dto) {
        Relatorio entity = new Relatorio();
        entity.setAlerta(dto.getAlerta());
        entity.setOcorrencia(dto.getOcorrencia());
        entity.setDataRelatorio(dto.getDataRelatorio());
        entity.setResumo(dto.getResumo());
        return entity;
    }

    public RelatorioDTO toDTO(Relatorio entity) {
        RelatorioDTO dto = new RelatorioDTO();
        dto.setAlerta(entity.getAlerta());
        dto.setOcorrencia(entity.getOcorrencia());
        dto.setDataRelatorio(entity.getDataRelatorio());
        dto.setResumo(entity.getResumo());
        return dto;
    }
}
