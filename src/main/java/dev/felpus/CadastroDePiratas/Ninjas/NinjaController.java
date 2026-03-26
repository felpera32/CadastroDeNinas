package dev.felpus.CadastroDePiratas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {



    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/msg")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa")
    public String boasVindas(){
        return "Primeira mensagem dessa rota";
    }



    // CRUD
    //add ninja (CREATE)
    //@RequestBody manda json com os dados pelo corpo da requisição
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Essa rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (id): " + novoNinja.getId());
    }

    //Listar ninjas (READ)
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "Essa rota lista todos os ninjas do banco de dados")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //mostrar todos os ninjas por ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por ID", description = "Essa rota lista um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não existe");
        }
    }


    //alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por ID", description = "Essa rota altera um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possivel alterar")
    })
    public ResponseEntity<?> alterarNinjaID(
            @Parameter(description = "Usuario manda o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja para ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO NinjaDTO){
        if(ninjaService.listarNinjasPorId(id) != null){
            NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id, NinjaDTO);
            return ResponseEntity.ok(ninjaAtualizado);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de ID: " + id + " não foi encontrado!");
        }

    }

    //deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta o ninja por ID", description = "Essa rota deleta um ninja pelo seu ID")

    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuario manda o ID no caminho da requisição")
            @PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID: " + id + " foi deletado com sucesso!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID: " + id + " não foi encontrado!");
        }
    }


}