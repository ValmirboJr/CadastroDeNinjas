package org.example.cadastrodeninjas.Missoes;

import org.example.cadastrodeninjas.Ninjas.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Repository
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
    List<MissoesModel> findByHabilitadoTrue();
    List<MissoesModel> findByHabilitadoFalse();
}
