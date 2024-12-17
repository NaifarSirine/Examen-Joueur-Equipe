package tn.esprit.spring.Schedular;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.Entities.Rencontre;
import tn.esprit.spring.Services.IService;

@AllArgsConstructor
@Component
@Slf4j
public class SchedularClass {
    IService service;

    @Scheduled(cron = "0 0 8 * * *")
    public void method() {
        log.info("**** Les rencontres d'aujourd'hui ****");
        for (Rencontre r : service.rencontreDeDate()) {
            log.info("Rencontre entre " + r.getEquipe1().getNomEquipe() + " et " + r.getEquipe2().getNomEquipe() + " à " + r.getNomStade());
        }
    }
}
