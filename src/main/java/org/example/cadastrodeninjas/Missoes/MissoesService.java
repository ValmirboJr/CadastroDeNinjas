package org.example.cadastrodeninjas.Missoes;

import org.example.cadastrodeninjas.Ninjas.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    @Autowired
    private MissoesMapper missoesMapper;

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel>missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }
    public MissoesDTO listarMissaoPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return  missoesModel.map(missoesMapper::map)
                .orElse(null);
    }
    public List<MissoesDTO> listarMissoesAtivas() {
        return missoesRepository.findByAtiva()
                .stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }
    public List<MissoesDTO> listarMissoesDesativas() {
        return missoesRepository.findByInativa()
                .stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }
    public MissoesDTO AtivarMissaoPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map)
                .orElse(null);
    }
    public MissoesDTO DesativaMissoesPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map)
                .orElse(null);
    }
    public MissoesDTO CriarMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

}
