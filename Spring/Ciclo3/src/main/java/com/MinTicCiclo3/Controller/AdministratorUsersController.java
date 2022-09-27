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

import com.MinTicCiclo3.Model.AdministratorUsers;
import com.MinTicCiclo3.Service.AdministratorUsersService;

@RestController
@RequestMapping("/api/usuariosAdmin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class AdministratorUsersController {
    

    @Autowired
    private AdministratorUsersService usuarioAdminService;

    @GetMapping("/usuariosAdminCompleta")
    public List<AdministratorUsers> obtenerUsuarioAdminCompleta() {
        return usuarioAdminService.obtenerUsuariosAdminCompleta();
    }

    @GetMapping("/{id}")
    public Optional<AdministratorUsers> obtenerUsuarioAdminId(@PathVariable("id") Integer identificador) {
        return usuarioAdminService.obtenerUsuariosAdminId(identificador);
    }

    @PostMapping("salvarUsuariosAdmin")
    @ResponseStatus(HttpStatus.CREATED)
    public AdministratorUsers salvarUsuarioAdmin(@RequestBody AdministratorUsers usuarioAdmin) {
        return usuarioAdminService.salvarUsuariosAdmin(usuarioAdmin);

    }

    // Consultas personalizadas
    @GetMapping("/usuariosAdmincompleta/jpql")
    public List<AdministratorUsers> obtenerUsuariosAdminCompletaJPQL() {
        return usuarioAdminService.obtenerUsuariosAdminCompletaJPQL();
    }
}
