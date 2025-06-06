package br.com.fiap.guardiao.verde.controller;

import br.com.fiap.guardiao.verde.domain.dto.UsuarioDTO;
import br.com.fiap.guardiao.verde.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/usuarios")
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
        UsuarioDTO created = service.save(dto);
        return ResponseEntity.ok(created);
    }
}
