package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entities.Arbitre;
import tn.esprit.spring.Entities.Equipe;
import tn.esprit.spring.Entities.Rencontre;
import tn.esprit.spring.Repositories.ArbitreRepo;
import tn.esprit.spring.Repositories.EquipeRepo;
import tn.esprit.spring.Repositories.JoueurRepo;
import tn.esprit.spring.Repositories.RencontreRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceClass implements IService {
    ArbitreRepo arbitreRepo;
    EquipeRepo equipeRepo;
    JoueurRepo joueurRepo;
    RencontreRepo rencontreRepo;

    @Override
    public Arbitre ajouterArbitre(Arbitre arbitre) {
        return arbitreRepo.save(arbitre);
    }

    @Override
    public Equipe ajouterEquipeEtJoueurs(Equipe equipe) {
        return equipeRepo.save(equipe);
    }

    @Override
    public Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, int idEquipe1, int idEquipe2) {
        Equipe equipe1 = equipeRepo.findById(idEquipe1).get();
        Equipe equipe2 = equipeRepo.findById(idEquipe2).get();
        // Equipe child
        rencontre.setEquipe1(equipe1);
        rencontre.setEquipe2(equipe2);
        rencontre.setNbre_but(0);
        return rencontreRepo.save(rencontre);
    }

    @Override
    public void affecterArbitreARencontre(String nomA, String prenomA, int idRencontre) throws Exception {
        Arbitre arbitre = arbitreRepo.getByNomAndPrenom(nomA, prenomA);
        Rencontre rencontre = rencontreRepo.findById(idRencontre).get();
        if (arbitre.getNiveau().equals(rencontre.getNiveau())) {
            //Arbitre child
            rencontre.setArbitre(arbitre);
            rencontreRepo.save(rencontre);
        }
        else {
            throw new Exception("Exception déclanchée");
        }
    }

    @Override
    public List<Rencontre> rencontreDeDate() { //KEYWORD
        return rencontreRepo.findByDateMatch(LocalDate.now());
    }

    @Override
    public List<Arbitre> recupererArbitresPourUneEquipe(int idEquipe) { //JPQL
        return arbitreRepo.findDistinctByEquipeIdInRencontres(idEquipe);
    }

    @Override
    public void incrementerNbreBut(int idRencontre) { //JPQL
        rencontreRepo.incrementerNbreBut(idRencontre,LocalDate.now());
    }


}
