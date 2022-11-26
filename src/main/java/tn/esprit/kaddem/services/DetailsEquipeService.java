package tn.esprit.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.DetailsEquipe;
import tn.esprit.kaddem.repositories.DetailsEquipeRepository;

import java.util.List;

@Service
public class DetailsEquipeService implements IDetailsEquipeService {
    @Autowired
    DetailsEquipeRepository de;
    @Override
    public DetailsEquipe ajouterDetailEquipe(DetailsEquipe d) {
        return de.save(d);
    }

    @Override
    public List<DetailsEquipe> ajouterDetailEquipes(List<DetailsEquipe> detailsEquipes) {
        return (List<DetailsEquipe>) de.saveAll(detailsEquipes);
    }

    @Override
    public DetailsEquipe modifierDetailEquipe (DetailsEquipe d) {
        return de.save(d);
    }

    @Override
    public List<DetailsEquipe>modifierDetailEquipes(List<DetailsEquipe> detailEquipe) {
        return (List<DetailsEquipe>) de.saveAll(detailEquipe);
    }

    @Override
    public List<DetailsEquipe>recupereDetailEquipe() {
        return (List<DetailsEquipe>) de.findAll();
    }

    @Override
    public DetailsEquipe recupereAvecId(long idDetailEquipe) {
        return  de.findById(idDetailEquipe).get();
    }

    @Override
    public void supprimerDetailEquipe(DetailsEquipe d) {
        de.delete(d);

    }

    @Override
    public void supprimerDetailEquipeAvecId(long idDetailEquipe) {
        de.deleteById(idDetailEquipe);

    }
}