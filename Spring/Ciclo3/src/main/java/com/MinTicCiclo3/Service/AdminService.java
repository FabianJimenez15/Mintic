package com.MinTicCiclo3.Service;

//import java.util.List;
//import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.MinTicCiclo3.Model.Admin;
//import com.MinTicCiclo3.Repository.AdminRepository;

@Service
public class AdminService {
       
 
    /*@Autowired
    private AdminRepository adminRepository;

    public List<Admin> obtenerAdminCompleta() {
        return adminRepository.obtenerAdminCompleta();
    }

    public Optional<Admin> obtenerAdminId(Integer id) {
        return adminRepository.obtenerAdminId(id);
    }

    public Admin salvarAdmin(Admin admin) {
        if (admin.getId() == null) {
            return adminRepository.salvarAdmin(admin);
        } else {

            Optional<Admin> adminAuxiliar = adminRepository.obtenerAdminId(admin.getId());
            if (adminAuxiliar.isEmpty()) {
                return adminRepository.salvarAdmin(admin);
            } else {
                return admin;
            }
        }

    }
    // JPQL

    public List<Admin> obtenerAdminCompletaJPQL() {
        return adminRepository.obtenerAdminCompletaJPQL();
    }*/

}
