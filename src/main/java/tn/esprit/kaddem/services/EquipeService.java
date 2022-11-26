package tn.esprit.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.repositories.EquipeRepository;

import java.util.List;

@Service
public class EquipeService implements IEquipeService{
    @Autowired
    EquipeRepository eqr;
    @Override
    public Equipe ajouterEquipe(Equipe eq) {
        return eqr.save(eq);
    }

    @Override
    public List<Equipe> ajouterEquipes(List<Equipe> equipe) {
        return (List<Equipe>) eqr.saveAll(equipe);
    }

    @Override
    public Equipe modifierEquipe(Equipe eq) {
        return eqr.save(eq);
    }

    @Override
    public List<Equipe> modifierEquipes(List<Equipe> equipe) {
        return (List<Equipe>) eqr.saveAll(equipe);
    }

    @Override
    public List<Equipe> recupereEquipe() {
        return (List<Equipe>) eqr.findAll();
    }

    @Override
    public Equipe recupereEquipeAvecId(long idEquipe) {
        return eqr.findById(idEquipe).get();
    }

    @Override
    public void supprimerEquipe(Equipe eq) {
        eqr.delete(eq);
    }

    @Override
    public void supprimerEquipeAvecId(long idEquipe) {
        eqr.deleteById(idEquipe);

    }
}
