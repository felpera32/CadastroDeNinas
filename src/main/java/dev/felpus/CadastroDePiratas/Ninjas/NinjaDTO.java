package dev.felpus.CadastroDePiratas.Ninjas;
import dev.felpus.CadastroDePiratas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String imgUrl;
    private int idade;
    private String email;
    private MissoesModel missoes;
    private String rank;
}
