package tn.esprit.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.Entities.Joueur;

public interface JoueurRepo extends JpaRepository<Joueur, Integer> {
}
