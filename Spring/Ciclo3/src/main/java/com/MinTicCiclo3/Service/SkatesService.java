package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.Skates;
import com.MinTicCiclo3.Repository.SkatesRepository;

@Service
public class SkatesService {

    @Autowired
    private SkatesRepository skatesRepository;

    public List<Skates> obtenerSkatesCompleta() {
        return skatesRepository.obtenerSkatesCompleta();
    }

    public Optional<Skates> obtenerSkatesId(Integer id) {
        return skatesRepository.obtenerSkatesId(id);
    }

    public Skates salvarSkates(Skates skates) {
        if (skates.getId() == null) {
            return skatesRepository.salvarSkates(skates);
        } else {

            Optional<Skates> skatesAuxiliar = skatesRepository.obtenerSkatesId(skates.getId());
            if (skatesAuxiliar.isEmpty()) {
                return skatesRepository.salvarSkates(skates);
            } else {
                return skates;
            }
        }

    }
    // JPQL

    public List<Skates> obtenerSkatesCompletaJPQL() {
        return skatesRepository.obtenerSkatesCompletaJPQL();
    }
}
