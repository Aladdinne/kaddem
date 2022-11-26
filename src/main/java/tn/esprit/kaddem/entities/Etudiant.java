package tn.esprit.kaddem.entities;

import lombok.*;

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
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String prenomE;
    private  String nomE;
    @Enumerated(EnumType.ORDINAL)
    private Domaine domaine;
    @OneToMany(mappedBy = "etud")
    private List<Contrat> contrats;
    @ManyToMany(mappedBy = "listetud")
    private List<Equipe> listequipe;
    @ManyToOne
    private Departement departs;

}
