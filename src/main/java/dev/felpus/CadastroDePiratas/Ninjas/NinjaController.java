package dev.felpus.CadastroDePiratas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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
    @GetMapping("/todos")
    public String mostrarTodos(){
        return "Mostrando os ninjas";
    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/todosID")
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