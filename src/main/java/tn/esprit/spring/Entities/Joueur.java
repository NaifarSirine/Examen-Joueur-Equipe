package tn.esprit.spring.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.Entities.Enum.Poste;

@Entity
@Table(name = "t-joueur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    @Enumerated(EnumType.STRING)
    Poste poste;
    int num_maillot;
    @ManyToOne
    Equipe equipe;
}
