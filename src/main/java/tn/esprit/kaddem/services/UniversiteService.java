package tn.esprit.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Universite;
import tn.esprit.kaddem.repositories.DepartementRepository;
import tn.esprit.kaddem.repositories.UniversiteRepository;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService {
    @Autowired
    UniversiteRepository cr;
    @Autowired
    DepartementRepository dp;

    @Override
    public Universite ajouterUniversite(Universite u) {
        return cr.save(u);
    }

    @Override
    public List<Universite> ajouterUniversites(List<Universite> Universite) {
        return (List<Universite>) cr.saveAll(Universite);
    }

    @Override
    public Universite modifierUniversite(Universite u) {
        return cr.save(u);
    }

    @Override
    public List<Universite> modifierUniversites(List<Universite> universites) {
        return (List<Universite>) cr.saveAll(universites);
    }

    @Override
    public List<Universite> recupereUniversite() {
        return (List<Universite>) cr.findAll();
    }

    @Override
    public Universite recupereAvecId(long idUniversite) {
        return cr.findById(idUniversite).get();
    }

    @Override
    public void supprimerUniversite(Universite u) {
        cr.delete(u);

    }

    @Override
    public void supprimerUniversiteAvecId(long idUniversite) {
        cr.deleteById(idUniversite);

    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite u = cr.findById(Long.valueOf(idUniversite)).get();//parent
        Departement d = dp.findById(Long.valueOf(idDepartement)).get();//child
        //on affecte le child au parent
        u.getDepart().add(d);
        cr.save(u);
    }

    @Override
    public void desaffecteUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite u = cr.findById(Long.valueOf(idUniversite)).get();//parent
        Departement d = dp.findById(Long.valueOf(idDepartement)).get();//child
        u.getDepart().remove(d);
        cr.save(u);
    }
}