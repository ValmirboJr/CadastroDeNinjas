package org.example.cadastrodeninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.CriarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Ninja Criada com sucesso!" + novoNinja.getNome() + " (ID) " + novoNinja.getId());
    }

    @GetMapping
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.ListarNinjas();
        return ResponseEntity.ok(ninjas);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable long id) {
        NinjaDTO ninja = ninjaService.ListarNinjasComId(id);
        if (ninja != null) {
            return ResponseEntity.ok("Ninja Encontrado!" + ninja.getId());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ninja.getId()+" Não encontrado! ");
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjas(@PathVariable long id) {
        if (ninjaService.ListarNinjasComId(id) != null) {
            ninjaService.DeletarNinjaporID(id);
            return ResponseEntity.ok(id +" Ninja Deletada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> editarNinjas(@PathVariable long id, @RequestBody NinjaDTO ninjaatt) {
        NinjaDTO ninja = ninjaService.EditarNinja(id, ninjaatt);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja Não encontrado");
        }
    }
}
