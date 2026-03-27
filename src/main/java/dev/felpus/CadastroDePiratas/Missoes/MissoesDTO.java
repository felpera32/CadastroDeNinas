package dev.felpus.CadastroDePiratas.Missoes;
import dev.felpus.CadastroDePiratas.Ninjas.NinjaDTO;
import dev.felpus.CadastroDePiratas.Ninjas.NinjaModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {
    private Long id;
    private String nomeMissao;
    private String dificuldadeMissao;
    private List<NinjaDTO> ninjas;

}
