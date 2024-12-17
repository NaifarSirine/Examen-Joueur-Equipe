package tn.esprit.spring.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.Entities.Enum.Niveau;

import java.time.LocalDate;

@Entity
@Table(name = "t-rencontre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate dateMatch;
    int nbre_but;
    String nomStade;
    @Enumerated(EnumType.STRING)
    Niveau niveau;
    @ManyToOne
    Arbitre arbitre;
    @ManyToOne
    Equipe equipe1;
    @ManyToOne
    Equipe equipe2;

}
