package org.example.cadastrodeninjas.Ninjas.model;

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

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    }

