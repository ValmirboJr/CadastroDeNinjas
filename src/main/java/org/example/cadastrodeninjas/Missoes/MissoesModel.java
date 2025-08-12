package org.example.cadastrodeninjas.Missoes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cadastrodeninjas.Ninjas.controller.model.NinjaModel;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_Missao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeMissao;
    private String descricaoMissao;
    private Date dataMissao;
    private String Dificuldade;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> Ninjas;
    private boolean habilitado;


}
