package com.MinTicCiclo3.Repository.Crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.MinTicCiclo3.Model.AdministratorUsers;

public interface AdministratorUsersCrudRepository extends CrudRepository<AdministratorUsers, Integer>{
      // En SQL select * from tabla_UsuariosAdmin as xxx where nombre ="xxxxx"
    // pap es el as de la tabla name es el nombre del atributo en la entidad.
    // nombreUsuariosAdmin pasa el valor a la variable n
    // SELECT a FROM Autor a ORDER BY a.nombre, a.apellidos
    @Query("select todo from Patineta todo")
    public List<AdministratorUsers> obtenerUsuariosAdminCompletaJPQL();
}
