package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.UsuariosAdmin;
import com.MinTicCiclo3.Repository.UsuariosAdminRepository;

@Service
public class UsuariosAdminService {
    

    @Autowired
    private UsuariosAdminRepository usuariosAdminRepository;

    public List<UsuariosAdmin> obtenerUsuariosAdminCompleta() {
        return usuariosAdminRepository.obtenerUsuariosAdminCompleta();
    }

    public Optional<UsuariosAdmin> obtenerUsuariosAdminId(Integer id) {
        return usuariosAdminRepository.obtenerUsuariosAdminId(id);
    }

    public UsuariosAdmin salvarUsuariosAdmin(UsuariosAdmin usuariosAdmin) {
        if (usuariosAdmin.getId() == null) {
            return usuariosAdminRepository.salvarUsuariosAdmin(usuariosAdmin);
        } else {

            Optional<UsuariosAdmin> usuariosAdminAuxiliar = usuariosAdminRepository.obtenerUsuariosAdminId(usuariosAdmin.getId());
            if (usuariosAdminAuxiliar.isEmpty()) {
                return usuariosAdminRepository.salvarUsuariosAdmin(usuariosAdmin);
            } else {
                return usuariosAdmin;
            }
        }

    }
    // JPQL

    public List<UsuariosAdmin> obtenerUsuariosAdminCompletaJPQL() {
        return usuariosAdminRepository.obtenerUsuariosAdminCompletaJPQL();
    }
}
