package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.UsuariosAdmin;
import com.MinTicCiclo3.Repository.Crud.UsuariosAdminCrudRepository;

@Repository
public class UsuariosAdminRepository {

    @Autowired
    private UsuariosAdminCrudRepository usuariosAdminCrudRepository;

    public List<UsuariosAdmin> obtenerUsuariosAdminCompleta() {
        return (List<UsuariosAdmin>) usuariosAdminCrudRepository.findAll();
    }

    public Optional<UsuariosAdmin> obtenerUsuariosAdminId(Integer id) {
        return usuariosAdminCrudRepository.findById(id);
    }

    public UsuariosAdmin salvarUsuariosAdmin(UsuariosAdmin usuariosAdmin) {
        return usuariosAdminCrudRepository.save(usuariosAdmin);
    }

    // Uso JPQL Java Persitence Query Language

    public List<UsuariosAdmin> obtenerUsuariosAdminCompletaJPQL() {
        return usuariosAdminCrudRepository.obtenerUsuariosAdminCompletaJPQL();
    }
}
