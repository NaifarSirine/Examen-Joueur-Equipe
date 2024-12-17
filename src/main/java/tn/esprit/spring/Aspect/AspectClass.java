package tn.esprit.spring.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class AspectClass {
    @AfterThrowing ("execution(* tn.esprit.spring.Services.ServiceClass.affecterArbitreARencontre(..))")
    public void afficher(){
        log.warn("Il faut affecter un arbitre de meme niveau que la rencontre");
    }
}
