package org.example.cadastrodeninjas.Missoes;

import org.example.cadastrodeninjas.Ninjas.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    @Autowired
    private NinjaRepository ninjaRepository;




}
