package dev.felpus.CadastroDePiratas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {



    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/msg")
    public String boasVindas(){
        return "Primeira mensagem dessa rota";
    }



    // CRUD
    //add ninja (CREATE)
    //@RequestBody manda json com os dados pelo corpo da requisição
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //procurar ninjas por id (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //mostrar todos os ninjas por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }


    //alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaID(){
        return "Alterar ninja por ID";
    }

    //deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaID(){
        return "Deletar ninja por ID";
    }


}