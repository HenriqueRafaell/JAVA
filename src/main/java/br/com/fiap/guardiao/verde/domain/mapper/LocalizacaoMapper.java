package br.com.fiap.guardiao.verde.domain.mapper;

import br.com.fiap.guardiao.verde.domain.dto.LocalizacaoDTO;
import br.com.fiap.guardiao.verde.domain.entity.Localizacao;

public class LocalizacaoMapper {
	
	public static Localizacao toEntity(LocalizacaoDTO dto) {
		Localizacao localizacao = new Localizacao();
		localizacao.setNomeLocal(dto.getNomeLocal());
		localizacao.setLatitude(dto.getLatitude());
		localizacao.setLongitude(dto.getLongitude());
		return localizacao;
	}
	
}
