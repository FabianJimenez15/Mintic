package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.Patineta;
import com.MinTicCiclo3.Repository.PatinetaRepository;

@Service
public class PatinetaService {

    @Autowired
    private PatinetaRepository patinetaRepository;

    public List<Patineta> obtenerPatinetaCompleta() {
        return patinetaRepository.obtenerPatinetaCompleta();
    }

    public Optional<Patineta> obtenerPatinetaId(Integer id) {
        return patinetaRepository.obtenerPatinetaId(id);
    }

    public Patineta salvarPatineta(Patineta patineta) {
        if (patineta.getId() == null) {
            return patinetaRepository.salvarPatineta(patineta);
        } else {

            Optional<Patineta> patinetaAuxiliar = patinetaRepository.obtenerPatinetaId(patineta.getId());
            if (patinetaAuxiliar.isEmpty()) {
                return patinetaRepository.salvarPatineta(patineta);
            } else {
                return patineta;
            }
        }

    }
    // JPQL

    public List<Patineta> obtenerPatinetaCompletaJPQL() {
        return patinetaRepository.obtenerPatinetaCompletaJPQL();
    }
}
