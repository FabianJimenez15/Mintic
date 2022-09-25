package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.Patineta;
import com.MinTicCiclo3.Repository.Crud.PatinetaCrudRepository;


@Repository
public class PatinetaRepository {
    
    @Autowired
    private PatinetaCrudRepository patinetaCrudRepository;
    
    public List <Patineta> obtenerPatinetaCompleta(){
        return   (List<Patineta>) patinetaCrudRepository.findAll();
    }
    public Optional<Patineta> obtenerPatinetaId(Integer id){
        return patinetaCrudRepository.findById(id);
    }
    public Patineta salvarPatineta(Patineta patineta){
        return patinetaCrudRepository.save(patineta);
    }

    // Uso JPQL Java Persitence Query Language
    /*    public List<Patineta> obtenerPatinetaCompletaJPQL(){
        return patinetaCrudRepository.obtenerPatinetaCompletaJPQL();
    }
*/

}
