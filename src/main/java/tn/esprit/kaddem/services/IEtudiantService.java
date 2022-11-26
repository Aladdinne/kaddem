package tn.esprit.kaddem.services;


import tn.esprit.kaddem.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant ajouterEtudiant (Etudiant e);
    List<Etudiant> ajouterEtudiants(List<Etudiant> etudiant);
    Etudiant modifierEtudiant (Etudiant e);
    List<Etudiant>modifierEtudiants(List<Etudiant> etudiant);

    List<Etudiant>recupereEtudiant();
    Etudiant recupereEtudiantAvecId(long idEtudiant);
    void supprimerEtudiant(Etudiant e);
    void supprimerEtudiantAvecId(long idEtudiant);
    void assignEtudiantToDepartement (Integer etudiantId, Integer departementId);
    void desaffecteEtudiantToDepartement (Integer etudiantId);
}
