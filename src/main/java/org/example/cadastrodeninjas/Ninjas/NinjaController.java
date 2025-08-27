package org.example.cadastrodeninjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ninjas", description = "Gerenciamento de Ninjas")
@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar Ninja", description = "Cria um novo Ninja")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ninja criado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.CriarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso! " + novoNinja.getNome() + " (ID) " + novoNinja.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Ninjas", description = "Retorna todos os Ninjas")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.ListarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Buscar Ninja por ID", description = "Retorna um Ninja específico pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable long id) {
        NinjaDTO ninja = ninjaService.ListarNinjasComId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar Ninja", description = "Remove um Ninja pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja deletado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjas(@PathVariable long id) {
        if (ninjaService.ListarNinjasComId(id) != null) {
            ninjaService.DeletarNinjaporID(id);
            return ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar Ninja", description = "Atualiza os dados de um Ninja pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja atualizado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> editarNinjas(@PathVariable long id, @RequestBody NinjaDTO ninjaatt) {
        NinjaDTO ninja = ninjaService.EditarNinja(id, ninjaatt);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }
}
