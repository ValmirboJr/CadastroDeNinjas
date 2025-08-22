package org.example.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cadastro")
public class NinjaController {


    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.CriarNinja(ninja);
    }

    @GetMapping
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.ListarNinjas();
    }


    @PostMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable long id) {
        return ninjaService.ListarNinjasComId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjas(@PathVariable long id) {
        ninjaService.DeletarNinjaporID(id);
    }
    @PutMapping("/alterar/{id}")
    public NinjaDTO editarNinjas(@PathVariable long id, @RequestBody NinjaDTO ninjaatt) {
    return ninjaService.EditarNinja(id, ninjaatt);
    }
}
