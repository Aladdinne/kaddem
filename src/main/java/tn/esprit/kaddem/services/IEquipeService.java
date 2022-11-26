package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    Equipe ajouterEquipe (Equipe eq);
    List<Equipe> ajouterEquipes(List<Equipe> equipe);
    Equipe modifierEquipe (Equipe eq);
    List<Equipe>modifierEquipes(List<Equipe> equipe);

    List<Equipe>recupereEquipe();
    Equipe recupereEquipeAvecId(long idEquipe);
    void supprimerEquipe(Equipe eq);
    void supprimerEquipeAvecId(long idEquipe);
}
