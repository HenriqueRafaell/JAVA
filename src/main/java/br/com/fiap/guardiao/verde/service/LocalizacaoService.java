package br.com.fiap.guardiao.verde.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.guardiao.verde.domain.dto.LocalizacaoDTO;
import br.com.fiap.guardiao.verde.domain.entity.Localizacao;
import br.com.fiap.guardiao.verde.domain.mapper.LocalizacaoMapper;
import br.com.fiap.guardiao.verde.domain.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
	private final LocalizacaoRepository localizacaoRepository;

	@Autowired
	public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
		this.localizacaoRepository = localizacaoRepository;
	}

	public Localizacao salvarLocalizacao(LocalizacaoDTO localizacaoDTO) {
		Localizacao localizacao = LocalizacaoMapper.toEntity(localizacaoDTO);
		return localizacaoRepository.save(localizacao);
	}

	public List<Localizacao> buscarTodos() {
		return localizacaoRepository.findAll();
	}
	
	public Localizacao atualizarLocalizacao(Long id, LocalizacaoDTO localizacoDTO) {
		Optional<Localizacao> optional = localizacaoRepository.findById(id);
		
		if (optional.isPresent()) {
			Localizacao localizacaoExists = optional.get();
			
			localizacaoExists.setLatitude(localizacoDTO.getLatitude());
			localizacaoExists.setLongitude(localizacoDTO.getLongitude());
			localizacaoExists.setNomeLocal(localizacoDTO.getNomeLocal());

			return localizacaoRepository.save(localizacaoExists);
		}
		return null;
	}

	public boolean deletarPorId(Long id) {
		if (localizacaoRepository.existsById(id)) {
			localizacaoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
