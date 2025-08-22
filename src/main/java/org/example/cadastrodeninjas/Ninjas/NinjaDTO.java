package org.example.cadastrodeninjas.Ninjas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cadastrodeninjas.Missoes.MissoesModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private long id;
    private String email;
    private String nome;
    private int idade;
    private MissoesModel missoes;
    private String rank;
}
