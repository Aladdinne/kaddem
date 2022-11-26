package tn.esprit.kaddem.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.ORDINAL)
    private Niveau niveau;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private DetailsEquipe detailsEquipe;
    @ManyToMany
    private List<Etudiant> listetud;
}
