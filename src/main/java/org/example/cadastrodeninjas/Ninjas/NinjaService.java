package org.example.cadastrodeninjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;
    @Autowired
    private NinjaMapper ninjaMapper;

    public List<NinjaDTO> ListarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO ListarNinjasComId(long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO CriarNinja(NinjaDTO ninja) {
        NinjaModel ninjinhabd = ninjaMapper.map(ninja);
        ninjaRepository.save(ninjinhabd);
        return ninjaMapper.map(ninjinhabd);
    }

    public void DeletarNinjaporID(long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO EditarNinja(long id, NinjaDTO ninjaatt) {
        Optional<NinjaModel> ninjabusca = ninjaRepository.findById(id);
        if (ninjabusca.isPresent()) {
            NinjaModel ninja = ninjaMapper.map(ninjaatt);
            ninjaatt.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
