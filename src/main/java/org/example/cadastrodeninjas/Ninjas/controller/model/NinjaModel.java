package org.example.cadastrodeninjas.Ninjas.controller.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cadastrodeninjas.Missoes.MissoesModel;

import java.util.List;

@Entity
@Table(name = "tb_Ninja")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    private String nome;
    private String email;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private List<MissoesModel> missoes;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    }

