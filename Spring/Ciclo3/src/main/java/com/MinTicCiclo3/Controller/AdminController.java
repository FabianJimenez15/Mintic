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

import com.MinTicCiclo3.Model.Admin;
import com.MinTicCiclo3.Service.AdminService;



@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/AdminCompleta")
    public List<Admin> obtenerAdminCompleta() {
        return adminService.obtenerAdminCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Admin> obtenerAdminId(@PathVariable("id") Integer identificador) {
        return adminService.obtenerAdminId(identificador);
    }

    @PostMapping("salvarAdmin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin salvarAdmin(@RequestBody Admin admin) {
        return adminService.salvarAdmin(admin);

    }

    // Consultas personalizadas
    @GetMapping("/Admincompleta/jpql")
    public List<Admin> obtenerAdminCompletaJPQL() {
        return adminService.obtenerAdminCompletaJPQL();
    }
    
}
