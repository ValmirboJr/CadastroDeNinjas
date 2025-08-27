package org.example.cadastrodeninjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Missões", description = "Gerenciamento de missões para ninjas")
@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesservice;

    public MissoesController(MissoesService missoesservice) {
        this.missoesservice = missoesservice;
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar missão", description = "Cria uma nova missão")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Missão criada"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO) {
        missoesservice.CriarMissoes(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão Criada com sucesso!");
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar missões", description = "Retorna todas as missões")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<MissoesDTO>> listarMissao(){
        return ResponseEntity.ok(missoesservice.listarMissoes());
    }

    @GetMapping("/listarAtivas")
    @Operation(summary = "Listar missões ativas", description = "Retorna missões com 'habilitado=true'")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<MissoesDTO>> listarMissaoAtivas(){
        return ResponseEntity.ok(missoesservice.listarMissoesAtivas());
    }

    @GetMapping("/listarDesativas")
    @Operation(summary = "Listar missões inativas", description = "Retorna missões com 'habilitado=false'")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<MissoesDTO>> listarMissaoInativas(){
        return ResponseEntity.ok(missoesservice.listarMissoesDesativas());
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar missão", description = "Atualiza uma missão pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão atualizada"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<MissoesDTO> alterarMissao(@PathVariable long id, @RequestBody MissoesDTO missoesDTO) {
        MissoesDTO atualizado = missoesservice.Alterar(id, missoesDTO);
        return ResponseEntity.ok(atualizado);
    }
}
