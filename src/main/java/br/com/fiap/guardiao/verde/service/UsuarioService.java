package br.com.fiap.guardiao.verde.service;

import br.com.fiap.guardiao.verde.domain.dto.UsuarioDTO;
import br.com.fiap.guardiao.verde.domain.entity.Usuario;
import br.com.fiap.guardiao.verde.domain.mapper.UsuarioMapper;
import br.com.fiap.guardiao.verde.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UsuarioDTO> findAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::toDTO)
                         .collect(Collectors.toList());
    }

    public UsuarioDTO save(UsuarioDTO dto) {
        Usuario usuario = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(usuario));
    }
}
