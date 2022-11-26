package tn.esprit.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.repositories.DepartementRepository;
import tn.esprit.kaddem.repositories.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantService implements IEtudiantService{
    @Autowired
    EtudiantRepository er;
    @Autowired
    DepartementRepository dr;
    @Override
    public Etudiant ajouterEtudiant(Etudiant e) {
        return er.save(e);
    }

    @Override
    public List<Etudiant> ajouterEtudiants(List<Etudiant> etudiant) {

        return (List<Etudiant>) er.saveAll(etudiant);
    }

    @Override
    public Etudiant modifierEtudiant(Etudiant e) {
        return er.save(e);
    }

    @Override
    public List<Etudiant> modifierEtudiants(List<Etudiant> etudiant) {

        return (List<Etudiant>) er.saveAll(etudiant);
    }

    @Override
    public List<Etudiant> recupereEtudiant() {
        return (List<Etudiant>) er.findAll();
    }

    @Override
    public Etudiant recupereEtudiantAvecId(long idEtudiant) {
        return  er.findById(idEtudiant).get();
    }

    @Override
    public void supprimerEtudiant(Etudiant e) {
        er.delete(e);
    }

    @Override
    public void supprimerEtudiantAvecId(long idEtudiant) {
        er.deleteById(idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
     Etudiant e=er.findById(Long.valueOf(etudiantId)).get();//parent
     Departement d =dr.findById(Long.valueOf(departementId)).get();//child
        //on affecte le child au parent
        e.setDeparts(d);
        er.save(e);
    }

    @Override
    public void desaffecteEtudiantToDepartement(Integer etudiantId) {
        Etudiant e=er.findById(Long.valueOf(etudiantId)).get();//parent
      e.setDeparts(null);
      er.save(e);
    }

}
