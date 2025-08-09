package org.example.cadastrodeninjas.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "tb_Ninja")
public class Ninja {


    String nome;
    String email;
    int idade;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public Ninja() {

    }

    public Ninja(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
}

