package dev.felpus.CadastroDePiratas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/msg")
    public String boasVindas(){
        return "Primeira mensagem dessa rota";
    }



    // CRUD
    //add ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //procurar ninjas por id (READ)
    @GetMapping("/listar")
    public String mostrarTodos(){
        return "Mostrando os ninjas";
    }

    //mostrar todos os ninjas por ID (READ)
    @GetMapping("/listarID")
    public String mostrarPorID(){
        return "Mostrando os ninjas por ID";
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