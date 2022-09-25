package com.MinTicCiclo3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MinTicCiclo3.Model.UsuariosAdmin;
import com.MinTicCiclo3.Service.UsuariosAdminService;

@RestController
@RequestMapping("/api/usuarioAdmin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class UsuariosAdminController {
    

    @Autowired
    private UsuariosAdminService usuarioAdminService;

    @GetMapping("/usuarioAdminCompleta")
    public List<UsuariosAdmin> obtenerUsuarioAdminCompleta() {
        return usuarioAdminService.obtenerUsuariosAdminCompleta();
    }

    @GetMapping("/{id}")
    public Optional<UsuariosAdmin> obtenerUsuarioAdminId(@PathVariable("id") Integer identificador) {
        return usuarioAdminService.obtenerUsuariosAdminId(identificador);
    }

    @PostMapping("salvarUsuarioAdmin")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuariosAdmin salvarUsuarioAdmin(@RequestBody UsuariosAdmin usuarioAdmin) {
        return usuarioAdminService.salvarUsuariosAdmin(usuarioAdmin);

    }

    // Consultas personalizadas
    @GetMapping("/usuarioAdmincompleta/jpql")
    public List<UsuariosAdmin> obtenerUsuariosAdminCompletaJPQL() {
        return usuarioAdminService.obtenerUsuariosAdminCompletaJPQL();
    }
}