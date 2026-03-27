package dev.felpus.CadastroDePiratas.Missoes;
import dev.felpus.CadastroDePiratas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {
    private final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissao(Model model){
        List<MissoesDTO> missao = missoesService.listarMissoes();
        model.addAttribute("missao", missao);
        return "listarMissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/adicionar")
    public String criarMissao(Model model){
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissao";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes){
        missoesService.criarMissao(missao);
        redirectAttributes.addFlashAttribute("Mensagem", "Missão criada com sucess");
        return "redirect:/missoes/ui/listar";

    }


    @GetMapping("/listar/{id}")
    public String listarMissaoPorId(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.listarPorId(id);
        if(missao != null){
            model.addAttribute("missao", missao);
            return "detalhesMissao";
        }
        else {
            model.addAttribute("mensagem", "Missão não encontrada!");
            return "listarMissoes";
        }
    }

}
