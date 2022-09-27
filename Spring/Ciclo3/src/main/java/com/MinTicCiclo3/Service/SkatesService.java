package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.skates;
import com.MinTicCiclo3.Repository.SkatesRepository;

@Service
public class SkatesService {

    @Autowired
    private SkatesRepository patinetaRepository;

    public List<skates> obtenerPatinetaCompleta() {
        return patinetaRepository.obtenerPatinetaCompleta();
    }

    public Optional<skates> obtenerPatinetaId(Integer id) {
        return patinetaRepository.obtenerPatinetaId(id);
    }

    public skates salvarPatineta(skates patineta) {
        if (patineta.getId() == null) {
            return patinetaRepository.salvarPatineta(patineta);
        } else {

            Optional<skates> patinetaAuxiliar = patinetaRepository.obtenerPatinetaId(patineta.getId());
            if (patinetaAuxiliar.isEmpty()) {
                return patinetaRepository.salvarPatineta(patineta);
            } else {
                return patineta;
            }
        }

    }
    // JPQL

    public List<skates> obtenerPatinetaCompletaJPQL() {
        return patinetaRepository.obtenerPatinetaCompletaJPQL();
    }
}
