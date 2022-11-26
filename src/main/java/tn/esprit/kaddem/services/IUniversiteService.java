
package tn.esprit.kaddem.services;


import tn.esprit.kaddem.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite ajouterUniversite (Universite u);
    List<Universite> ajouterUniversites(List<Universite> Universite);
    Universite modifierUniversite (Universite u);
    List<Universite> modifierUniversites(List<Universite> universites);

    List<Universite>recupereUniversite();
    Universite recupereAvecId(long idUniversite);
    void supprimerUniversite(Universite u);
    void supprimerUniversiteAvecId(long idUniversite);
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    void desaffecteUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
