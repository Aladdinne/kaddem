package tn.esprit.kaddem.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Domaine;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Specialite;

import java.util.Date;
import java.util.List;

public interface IContratService {
    Contrat ajouterContrat (Contrat c);
    List<Contrat> ajouterContrats(List<Contrat> contrat);
    Contrat modifierContat (Contrat c);
    List<Contrat>modifierContrats(List<Contrat> contart);

    List<Contrat>recupereContrat();
    Contrat recupereContratAvecId(long idContrat);
    void supprimerContrat(Contrat c);
    void supprimerContratAvecId(long idContrat);
    ////////////////////////////////////
    List<Contrat> recupererListContratsSelonDate(Date d);
    List<Contrat> selectsql(Date d);

    List<Contrat> selectJoinSQL(String nom, Domaine domaine);
    List<Contrat> selectJoinJPQL(String nom,Domaine d);
    void updatecontratSQL(@Param("d") Date date, @Param("s") Specialite spec);
    void updatecontratJPQL(Date d,Specialite s);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    Contrat affectContratToEtudiant (Contrat ce,String nomE,String prenomE);
}
