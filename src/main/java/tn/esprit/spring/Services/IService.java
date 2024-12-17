package tn.esprit.spring.Services;

import tn.esprit.spring.Entities.*;
import tn.esprit.spring.Entities.Enum.*;

import java.time.LocalDate;
import java.util.List;

public interface IService {
    Arbitre ajouterArbitre(Arbitre arbitre);
    Equipe ajouterEquipeEtJoueurs(Equipe equipe);
    Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, int idEquipe1, int idEquipe2);
    void affecterArbitreARencontre(String nomA, String prenomA, int idRencontre) throws Exception;
    List<Rencontre> rencontreDeDate(); // Schedular

    //Récuperer la liste des arbitres qui ont "arbitré" une équipe dont son id est passé en paramètre lors des rencontres
    List<Arbitre> recupererArbitresPourUneEquipe(int idEquipe); // KEYWORD
    void incrementerNbreBut(int idRencontre); // JPQL
}
