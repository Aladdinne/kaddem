package tn.esprit.kaddem.services;

import com.sun.jdi.LongValue;
import com.sun.tools.jdi.LongValueImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.kaddem.entities.*;
import tn.esprit.kaddem.repositories.ContratRepository;
import tn.esprit.kaddem.repositories.EquipeRepository;
import tn.esprit.kaddem.repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;

@Service //ou @Component
@Transactional
public class ContratService implements IContratService{
    @Autowired
    ContratRepository cr;
    @Autowired
    EquipeRepository eq;
    @Autowired
    EtudiantRepository et;
    @Override
    public Contrat ajouterContrat(Contrat c) {
        return cr.save(c);
    }

    @Override
    public List<Contrat> ajouterContrats(List<Contrat> contrat) {
        return (List<Contrat>) cr.saveAll(contrat);
    }

    @Override
    public Contrat modifierContat(Contrat c) {
        return cr.save(c);
    }

    @Override
    public List<Contrat> modifierContrats(List<Contrat> contrat) {
        return (List<Contrat>) cr.saveAll(contrat);
    }

    @Override
    public List<Contrat> recupereContrat() {
        return (List<Contrat>) cr.findAll();
    }

    @Override
    public Contrat recupereContratAvecId(long idContrat) {
        return  cr.findById(idContrat).get();
    }

    @Override
    public void supprimerContrat(Contrat c) {cr.delete(c);

    }
    @Override
    public void supprimerContratAvecId(long idContrat) {cr.deleteById(idContrat);

    }

    @Override
    public List<Contrat> recupererListContratsSelonDate(Date d) {
        return cr.selectedByDateDebutC(d);
    }

    @Override
    public List<Contrat> selectsql(Date d) {
        return cr.selectByDateDebutCSQL(d);
    }
    public List<Contrat> selectJoinSQL(String nom, Domaine domaine){
        return cr.selectJointureSQL(nom,domaine);
    }
    public List<Contrat> selectJoinJPQL(String nom,Domaine d){
        return cr.selectJointureJPQL(nom,d);
    }
    public void updatecontratSQL(@Param("d") Date date, @Param("s") Specialite spec){
        cr.updateContratSQL(date, spec);
    }
    public void updatecontratJPQL(Date d,Specialite s){
        cr.updateContratJPQL(d,s);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat c =cr.findById(Long.valueOf(idContrat)).get();
        Equipe ec = eq.findById(Long.valueOf(idEquipe)).get();
        e=et. save(e);
        //association 1
        //contrat parent et etudiant child
        c.setEtud(e);
        cr.save(c);
        //association 2
        //equipe parent et etudiant child
        ec.getListetud().add(e);
        eq.save(ec);
        return e;
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e=et.findByNomEAndPrenomEContains(nomE,prenomE);//child
        Contrat c =cr.findById(ce.getIdContrat()).get();//parent
        //on affecte le child au parent
        c.setEtud(e);
        cr.save(c);
        return null;
    }


}
