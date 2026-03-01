package dev.felpus.CadastroDePiratas.Ninjas;
import dev.felpus.CadastroDePiratas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// Entity transforma uma classe uma entidade do DB
@Entity
@Table(name = "tb_cadastro")

@Data //Cria TODOS OS getter e setters
@NoArgsConstructor //Cria um construtor no args
@AllArgsConstructor //Cria um construtor com todos os argumentos
public class NinjaModel {

    @Id //Fala q o atributo abaixo e o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    private String email;

    //Mais de um ninja pra uma unica "missao"
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing key ou chave estrangeira

    private MissoesModel missoes;


}