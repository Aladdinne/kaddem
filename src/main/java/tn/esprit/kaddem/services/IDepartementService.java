package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Departement;

import java.util.List;

public interface IDepartementService {
    Departement ajouterDepartement (Departement d);
    List<Departement> ajouterDepartements(List<Departement> departement);
    Departement modifierDepartement (Departement d);
    List<Departement>modifierDepartements(List<Departement> departement);

    List<Departement>recupereDepartement();
    Departement recupereDepartementAvecId(long idDepartement);
    void supprimerDepartement(Departement d);
    void supprimerDepartementAvecId(long idDepartement);
}
