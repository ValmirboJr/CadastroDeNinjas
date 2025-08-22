package org.example.cadastrodeninjas.Ninjas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cadastrodeninjas.Missoes.MissoesModel;

@Entity
@Table(name = "tb_cadastro")
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
    private long id;

    private String rank;
    }

