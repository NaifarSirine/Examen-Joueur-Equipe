package tn.esprit.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.Entities.Arbitre;

import java.util.List;

public interface ArbitreRepo extends JpaRepository<Arbitre, Integer> {
    Arbitre getByNomAndPrenom(String nom, String prenom);
    @Query("SELECT DISTINCT a FROM Arbitre a JOIN a.rencontres r WHERE r.equipe1.id = ?1 OR " +
            "r.equipe2.id = ?1 ORDER BY a.nom")
    List<Arbitre> findDistinctByEquipeIdInRencontres(int equipeId);
}
