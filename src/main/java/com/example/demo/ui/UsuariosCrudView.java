package com.example.demo.ui;

import com.example.demo.domain.Usuario;
import com.example.demo.servicio.UsuarioService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("crud")
public class UsuariosCrudView extends VerticalLayout {

    public UsuariosCrudView(UsuarioService usuarioService) {
        GridCrud<Usuario> crud = new GridCrud<>(Usuario.class, usuarioService);
        add(crud);
    }

}
