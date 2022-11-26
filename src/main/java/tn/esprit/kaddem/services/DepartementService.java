package tn.esprit.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.repositories.DepartementRepository;

import java.util.List;

@Service
public class DepartementService implements IDepartementService{
    @Autowired
    DepartementRepository dr;
    @Override
    public Departement ajouterDepartement(Departement d) {
        return dr.save(d);
    }

    @Override
    public List<Departement> ajouterDepartements(List<Departement> departement) {
        return (List<Departement>) dr.saveAll(departement);
    }

    @Override
    public Departement modifierDepartement(Departement d) {
        return dr.save(d);
    }

    @Override
    public List<Departement> modifierDepartements(List<Departement> departement) {
        return (List<Departement>) dr.saveAll(departement);
    }

    @Override
    public List<Departement> recupereDepartement() {
        return (List<Departement>) dr.findAll();
    }

    @Override
    public Departement recupereDepartementAvecId(long idDepartement) {
        return  dr.findById(idDepartement).get();
    }

    @Override
    public void supprimerDepartement(Departement d) {
        dr.delete(d);

    }

    @Override
    public void supprimerDepartementAvecId(long idDepartement) {
        dr.deleteById(idDepartement);

    }
}
