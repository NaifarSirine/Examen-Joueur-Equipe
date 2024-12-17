package tn.esprit.spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t-equipe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nomEquipe;
    LocalDate dateCreation;
    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    List<Joueur> joueurs = new ArrayList<>();
    @OneToMany(mappedBy = "equipe1")
    @JsonIgnore
    List<Rencontre> rencontres = new ArrayList<>();
    @OneToMany(mappedBy = "equipe2")
    @JsonIgnore
    List<Rencontre> rencontres2 = new ArrayList<>();
}
