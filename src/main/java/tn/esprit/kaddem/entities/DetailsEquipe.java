package tn.esprit.kaddem.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DetailsEquipe implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailEquipe;
    private int salle;
    private String thematique;
    @OneToOne(mappedBy = "detailsEquipe")
    private Equipe e;

}
