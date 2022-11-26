package tn.esprit.kaddem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entities.Domaine;
import tn.esprit.kaddem.entities.Etudiant;

import java.util.Date;
import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {
    //select * from Etudiant where nomE="..."
    List<Etudiant>findByNomE(String nom);
    //select * from Etudiant where nomE="....." and prenomE like "%.....%"
    List<Etudiant>findByNomEAndPrenomEContains(String nom,String prenom);
    //select * from Etudiant where domaine ="....."
    List<Etudiant> findByDomaine(Domaine d);
    //select * from Etudiant e join Contrat c on ....id=.....id where c.dateDebutc='12/12/2025'
    List<Etudiant>findByContratsDateDebutC(Date date);
    //afficher la liste des etudiants qui sont affecte a la salle (Attribut dans DetailsEquipe) 2
    List<Etudiant> getByListequipeDetailsEquipeSalle(int salle);
    //afficher la list des etudiant qui sont affectes a la salle
    //(attribut dans detailequipe)2 et la thematique (attribut  dans detailsEquipe)
    //"sport"
   List<Etudiant>getByListequipeDetailsEquipeSalleAndListequipeDetailsEquipeThematique(int salle,String thematique);

}
