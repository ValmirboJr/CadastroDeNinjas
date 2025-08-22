package org.example.cadastrodeninjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cadastrodeninjas.Ninjas.NinjaModel;

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

    @Column(nullable = false)
    private String nomeMissao;
    @Column(nullable = false)
    private String descricaoMissao;
    @Column(nullable = false)
    private Date dataMissao;
    @Column(nullable = false)
    private String Dificuldade;
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> Ninjas;
    @Column(nullable = false)
    private boolean habilitado;
}
