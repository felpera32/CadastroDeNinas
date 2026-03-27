package dev.felpus.CadastroDePiratas.Missoes;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import dev.felpus.CadastroDePiratas.Ninjas.NinjaMapper;
import lombok.Data;

@Component
@Data
public class MissoesMapper {

    public  MissoesDTO map(MissoesModel missao) {
        NinjaMapper ninjaMapper = new NinjaMapper();
        if (missao == null) {
            return null;
        }
        MissoesDTO dto = new MissoesDTO();
        dto.setId(missao.getId());
        dto.setNomeMissao(missao.getNomeMissao());
        dto.setDificuldadeMissao(missao.getDificuldadeMissao());
        dto.setNinjas(
                Optional.ofNullable(missao.getNinjas())
                        .orElse(List.of())
                        .stream()
                        .map(ninjaMapper::map)
                        .toList()
        );
        return dto;
    }


    public  MissoesModel map(MissoesDTO dto) {
        if (dto == null) return null;

        MissoesModel missao = new MissoesModel();
        missao.setId(dto.getId());
        missao.setNomeMissao(dto.getNomeMissao());
        missao.setDificuldadeMissao(dto.getDificuldadeMissao());
        return missao;
    }
}
