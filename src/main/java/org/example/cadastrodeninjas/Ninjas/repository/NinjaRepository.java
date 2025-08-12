package org.example.cadastrodeninjas.Ninjas.repository;

import org.example.cadastrodeninjas.Ninjas.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {

}
