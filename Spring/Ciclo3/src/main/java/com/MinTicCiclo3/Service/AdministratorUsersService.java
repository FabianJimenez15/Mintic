package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.AdministratorUsers;
import com.MinTicCiclo3.Repository.AdministratorUsersRepository;

@Service
public class AdministratorUsersService {
    

    @Autowired
    private AdministratorUsersRepository usuariosAdminRepository;

    public List<AdministratorUsers> obtenerUsuariosAdminCompleta() {
        return usuariosAdminRepository.obtenerUsuariosAdminCompleta();
    }

    public Optional<AdministratorUsers> obtenerUsuariosAdminId(Integer id) {
        return usuariosAdminRepository.obtenerUsuariosAdminId(id);
    }

    public AdministratorUsers salvarUsuariosAdmin(AdministratorUsers usuariosAdmin) {
        if (usuariosAdmin.getId() == null) {
            return usuariosAdminRepository.salvarUsuariosAdmin(usuariosAdmin);
        } else {

            Optional<AdministratorUsers> usuariosAdminAuxiliar = usuariosAdminRepository.obtenerUsuariosAdminId(usuariosAdmin.getId());
            if (usuariosAdminAuxiliar.isEmpty()) {
                return usuariosAdminRepository.salvarUsuariosAdmin(usuariosAdmin);
            } else {
                return usuariosAdmin;
            }
        }

    }
    // JPQL

    public List<AdministratorUsers> obtenerUsuariosAdminCompletaJPQL() {
        return usuariosAdminRepository.obtenerUsuariosAdminCompletaJPQL();
    }
}
