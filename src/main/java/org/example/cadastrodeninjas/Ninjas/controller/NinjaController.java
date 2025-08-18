package org.example.cadastrodeninjas.Ninjas.controller;

import org.example.cadastrodeninjas.Ninjas.model.NinjaModel;
import org.example.cadastrodeninjas.Ninjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.CriarNinja(ninja);
    }

    @PostMapping
    public List<NinjaModel> listarNinjas(){
        return ninjaService.ListarNinjas();
    }


    @PostMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id) {
        return ninjaService.ListarNinjasComId(id);
    }

}
