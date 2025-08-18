package org.example.cadastrodeninjas.Ninjas.service;

import org.example.cadastrodeninjas.Ninjas.model.NinjaModel;
import org.example.cadastrodeninjas.Ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
   private NinjaRepository ninjaRepository;


    public List<NinjaModel> ListarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel ListarNinjasComId(long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel CriarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }
}
