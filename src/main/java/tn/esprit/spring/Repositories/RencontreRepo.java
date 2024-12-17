package tn.esprit.spring.Repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.Entities.Rencontre;

import java.time.LocalDate;
import java.util.List;

public interface RencontreRepo extends JpaRepository<Rencontre, Integer> {
    List<Rencontre> findByDateMatch(LocalDate Date);
    @Query("UPDATE Rencontre r SET r.nbre_but = r.nbre_but + 1 WHERE r.id =?1 and r.dateMatch=?2")
    @Modifying
    @Transactional
    void incrementerNbreBut(int idRencontre, LocalDate localDate);
}
