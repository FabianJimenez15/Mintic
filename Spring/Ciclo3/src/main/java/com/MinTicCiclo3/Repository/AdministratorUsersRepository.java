package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.AdministratorUsers;
import com.MinTicCiclo3.Repository.Crud.AdministratorUsersCrudRepository;

@Repository
public class AdministratorUsersRepository {

    @Autowired
    private AdministratorUsersCrudRepository usuariosAdminCrudRepository;

    public List<AdministratorUsers> obtenerUsuariosAdminCompleta() {
        return (List<AdministratorUsers>) usuariosAdminCrudRepository.findAll();
    }

    public Optional<AdministratorUsers> obtenerUsuariosAdminId(Integer id) {
        return usuariosAdminCrudRepository.findById(id);
    }

    public AdministratorUsers salvarUsuariosAdmin(AdministratorUsers usuariosAdmin) {
        return usuariosAdminCrudRepository.save(usuariosAdmin);
    }

    // Uso JPQL Java Persitence Query Language

    public List<AdministratorUsers> obtenerUsuariosAdminCompletaJPQL() {
        return usuariosAdminCrudRepository.obtenerUsuariosAdminCompletaJPQL();
    }
}
