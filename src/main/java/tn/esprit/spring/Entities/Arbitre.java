package tn.esprit.spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.Entities.Enum.Niveau;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t-arbitre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    String nationalite;
    @Enumerated(EnumType.STRING)
    Niveau niveau;
    @OneToMany(mappedBy = "arbitre")
    @JsonIgnore
    List<Rencontre> rencontres = new ArrayList<>();
}
