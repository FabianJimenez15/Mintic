package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.skates;
import com.MinTicCiclo3.Repository.Crud.SkatesCrudRepository;

@Repository
public class SkatesRepository {

    @Autowired
    private SkatesCrudRepository patinetaCrudRepository;

    public List<skates> obtenerPatinetaCompleta() {
        return (List<skates>) patinetaCrudRepository.findAll();
    }

    public Optional<skates> obtenerPatinetaId(Integer id) {
        return patinetaCrudRepository.findById(id);
    }

    public skates salvarPatineta(skates patineta) {
        return patinetaCrudRepository.save(patineta);
    }

    // Uso JPQL Java Persitence Query Language

    public List<skates> obtenerPatinetaCompletaJPQL() {
        return patinetaCrudRepository.obtenerPatinetaCompletaJPQL();
    }

}
