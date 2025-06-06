package br.com.fiap.guardiao.verde.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.guardiao.verde.domain.dto.UsuarioDTO;
import br.com.fiap.guardiao.verde.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/buscarTodos")
    public List<UsuarioDTO> getAll() {
        return service.findAll();
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO dto) {
        UsuarioDTO created = service.salvar(dto);
        return ResponseEntity.ok(created);
    }
}
