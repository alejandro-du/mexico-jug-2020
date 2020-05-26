package com.example.demo.ui;

import com.example.demo.domain.Usuario;
import com.example.demo.servicio.UsuarioService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("nuevo-usuario")
public class NuevoUsuarioView extends VerticalLayout {

    private TextField email = new TextField("Email");
    private PasswordField contrasena = new PasswordField("Contraseña");
    private DatePicker fechaDeNacimiento = new DatePicker("Fecha de nacimiento");
    private Checkbox bloqueado = new Checkbox("Bloqueado");

    public NuevoUsuarioView(UsuarioService usuarioService) {
        BeanValidationBinder<Usuario> binder = new BeanValidationBinder<>(Usuario.class);
        binder.bindInstanceFields(this);
        binder.setBean(new Usuario());

        Button guardar = new Button("Guardar", event -> {
            if (binder.validate().isOk()) {
                Usuario usuario = binder.getBean();
                usuarioService.add(usuario);
                Notification.show("Usuario guardado");
                binder.setBean(new Usuario());
            }
        });

        RouterLink listaDeUsuarios = new RouterLink("Lista de usuarios", UsuariosView.class);

        add(new FormLayout(email, contrasena, fechaDeNacimiento, bloqueado), guardar, listaDeUsuarios);
    }

}
