package org.example.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {

        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setDataMissao(missoesDTO.getDataMissao());
        missoesModel.setHabilitado(missoesDTO.isHabilitado());
        missoesModel.setDataMissao(missoesDTO.getDataMissao());
        missoesModel.setNomeMissao(missoesDTO.getNomeMissao());
        missoesModel.setDescricaoMissao(missoesDTO.getDescricaoMissao());
        return missoesModel;
    }
    public MissoesDTO map(MissoesModel missoesmodel) {

        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesmodel.getId());
        missoesDTO.setDificuldade(missoesmodel.getDificuldade());
        missoesDTO.setDataMissao(missoesmodel.getDataMissao());
        missoesDTO.setHabilitado(missoesmodel.isHabilitado());
        missoesDTO.setDataMissao(missoesmodel.getDataMissao());
        missoesDTO.setNomeMissao(missoesmodel.getNomeMissao());
        missoesDTO.setDescricaoMissao(missoesmodel.getNomeMissao());
        return missoesDTO;
    }
}
