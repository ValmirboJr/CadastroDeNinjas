package org.example.cadastrodeninjas.Missoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cadastrodeninjas.Ninjas.NinjaModel;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private long id;
    private String nomeMissao;
    private String descricaoMissao;
    private Date dataMissao;
    private String Dificuldade;
    private NinjaModel Ninjas;
    private boolean habilitado;
}
