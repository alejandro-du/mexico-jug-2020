package com.example.demo.ui;

import com.example.demo.domain.Usuario;
import com.example.demo.servicio.UsuarioService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("usuarios") // http://localhost:8080/usuarios
@Theme(value = Lumo.class, variant = Lumo.DARK)
@CssImport("./css/app.css")
public class UsuariosView extends VerticalLayout {

    public UsuariosView(UsuarioService usuarioService) {
        RouterLink nuevoUsuario = new RouterLink("Nuevo usuario", NuevoUsuarioView.class);

        Grid<Usuario> grid = new Grid<>();
        grid.addColumn(Usuario::getEmail).setHeader("Email");
        grid.addColumn(Usuario::getFechaDeNacimiento).setHeader("Fecha de nacimiento");
        grid.addColumn(usuario -> usuario.isBloqueado() ? "Sí" : "").setHeader("Bloqueado");
        grid.addComponentColumn(usuario -> new Button(VaadinIcon.TRASH.create(), event -> usuarioService.delete(usuario)));
        grid.setItems(usuarioService.findAll());

        add(nuevoUsuario, grid);
    }

}
