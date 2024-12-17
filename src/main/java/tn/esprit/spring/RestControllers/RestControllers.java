package tn.esprit.spring.RestControllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entities.Arbitre;
import tn.esprit.spring.Entities.Equipe;
import tn.esprit.spring.Entities.Rencontre;
import tn.esprit.spring.Services.IService;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class RestControllers {
    IService service;

    @PostMapping("ajouterArbitre")
    Arbitre ajouterArbitre(@RequestBody Arbitre arbitre){
        return service.ajouterArbitre(arbitre);
    }

    @PostMapping("ajouterEquipeEtJoueurs")
    Equipe ajouterEquipeEtJoueurs(@RequestBody Equipe equipe){
        return service.ajouterEquipeEtJoueurs(equipe);
    }

    @PostMapping("ajouterRencontreEtAffecterEquipes")
    Rencontre ajouterRencontreEtAffecterEquipes(@RequestBody Rencontre rencontre,@RequestParam int idEquipe1,@RequestParam int idEquipe2){
        return service.ajouterRencontreEtAffecterEquipes(rencontre,idEquipe1,idEquipe2);
    }

    @PutMapping("affecterArbitreARencontre")
    void affecterArbitreARencontre(@RequestParam String nomA,@RequestParam String prenomA,@RequestParam int idRencontre) throws Exception{
        service.affecterArbitreARencontre(nomA,prenomA,idRencontre);
    }

    @GetMapping("recupererArbitresPourUneEquipe")
    List<Arbitre> recupererArbitresPourUneEquipe(@RequestParam int idEquipe){
        return service.recupererArbitresPourUneEquipe(idEquipe);
    }

    @PutMapping("incrementerNbreBut")
    void incrementerNbreBut(@RequestParam int idRencontre){
        service.incrementerNbreBut(idRencontre);
    }
}
