package br.com.fiap.guardiao.verde.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.guardiao.verde.domain.dto.LocalizacaoDTO;
import br.com.fiap.guardiao.verde.domain.entity.Localizacao;
import br.com.fiap.guardiao.verde.service.LocalizacaoService;

@RestController	
@RequestMapping("/v1/localizacao")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoService localizacaoService;
	
	public LocalizacaoController(LocalizacaoService localizacaoService) {
		this.localizacaoService = localizacaoService;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Localizacao> criarLocalizacao(@RequestBody LocalizacaoDTO localizacaoDTO){
		Localizacao salvar = localizacaoService.salvarLocalizacao(localizacaoDTO);
		return ResponseEntity.ok(salvar);
	}
	
	@GetMapping("/buscarTodos")
	public ResponseEntity<List<Localizacao>> listarTodosLocalizacao(){
		List<Localizacao> localizacao = localizacaoService.buscarTodos();
		return ResponseEntity.ok(localizacao);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Localizacao> atualizarLocalizacao(
	        @PathVariable Long id,
	        @RequestBody LocalizacaoDTO localizacaoDTO) {

	    Localizacao localizacao = localizacaoService.atualizarLocalizacao(id, localizacaoDTO);

	    if (localizacao != null) {
	        return ResponseEntity.ok(localizacao);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
		boolean deletado = localizacaoService.deletarPorId(id);
		if(deletado) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
