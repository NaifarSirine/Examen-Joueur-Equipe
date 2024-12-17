package tn.esprit.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.Entities.Equipe;

public interface EquipeRepo extends JpaRepository<Equipe, Integer> {
}
