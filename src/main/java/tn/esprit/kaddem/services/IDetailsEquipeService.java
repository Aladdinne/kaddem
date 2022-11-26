package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.DetailsEquipe;

import java.util.List;

public interface IDetailsEquipeService {
    DetailsEquipe ajouterDetailEquipe (DetailsEquipe d);
    List<DetailsEquipe> ajouterDetailEquipes(List<DetailsEquipe> detailEquipe);
    DetailsEquipe modifierDetailEquipe (DetailsEquipe d);
    List<DetailsEquipe>modifierDetailEquipes(List<DetailsEquipe> detailEquipe);

    List<DetailsEquipe>recupereDetailEquipe();
    DetailsEquipe recupereAvecId(long idDetailEquipe);
    void supprimerDetailEquipe(DetailsEquipe d);
    void supprimerDetailEquipeAvecId(long idDetailEquipe);

}