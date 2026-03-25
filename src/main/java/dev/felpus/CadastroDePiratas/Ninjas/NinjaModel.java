package dev.felpus.CadastroDePiratas.Ninjas;
import dev.felpus.CadastroDePiratas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


// Entity transforma uma classe uma entidade do DB
@Entity
@Table(name = "tb_cadastro")

@Data //Cria TODOS OS getter e setters
@NoArgsConstructor //Cria um construtor no args
@AllArgsConstructor //Cria um construtor com todos os argumentos
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id //Fala q o atributo abaixo e o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column (name="img_url")
    private String imgUrl;

    @Column(name="idade")
    private int idade;

    @Column(unique = true, name="email") //Faz o dado ser unico
    private String email;

    @Column(name="rank")
    private String rank;

    //Mais de um ninja pra uma unica "missao"
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing key ou chave estrangeira

    private MissoesModel missoes;


}