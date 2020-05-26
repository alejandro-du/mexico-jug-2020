package com.example.demo.servicio;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

@Service
public class UsuarioService implements CrudListener<Usuario> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario add(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

}
