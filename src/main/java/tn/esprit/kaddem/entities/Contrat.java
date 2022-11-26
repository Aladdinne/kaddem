package tn.esprit.kaddem.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.TemporalType;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutC;
    @Temporal(TemporalType.DATE)
    private Date dateFinC;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private boolean archive;
    private float montantC;
    @ManyToOne
    private Etudiant etud;

}
