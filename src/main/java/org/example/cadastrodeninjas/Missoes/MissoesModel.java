package org.example.cadastrodeninjas.Missoes;

import jakarta.persistence.*;
import org.example.cadastrodeninjas.Ninjas.controller.model.NinjaModel;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_Missao")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeMissao;
    private String descricaoMissao;
    private Date dataMissao;
    private String Dificuldade;

    @OneToMany
    private List<NinjaModel> Ninjas;
    private boolean habilitado;


}
