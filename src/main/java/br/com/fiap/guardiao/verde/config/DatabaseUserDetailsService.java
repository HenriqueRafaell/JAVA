package br.com.fiap.guardiao.verde.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.guardiao.verde.domain.entity.Usuario;
import br.com.fiap.guardiao.verde.domain.repository.UsuarioRepository;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User.withUsername(usuario.getEmail())
                .password("{noop}" + usuario.getSenha()) 
                .roles(usuario.getTipoUsuario().getNome())
                .build();
    }
}