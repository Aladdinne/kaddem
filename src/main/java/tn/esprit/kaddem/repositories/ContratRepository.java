package tn.esprit.kaddem.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Domaine;
import tn.esprit.kaddem.entities.Specialite;


import java.util.Date;
import java.util.List;


@Repository
public interface ContratRepository extends CrudRepository <Contrat,Long> {
    //@Query()//=>pour ecrire une requette JPQL ou SQL
    //afficher la liste des contrat dont la date de debut est inferieur
    //a la date donne en parametre
    /////****************************************select********************************************//////////////////
    @Query("select c from Contrat c where c.dateDebutC<?1 ")//pour ecrire une requete JPQL(Orientée objet)
    List<Contrat> selectedByDateDebutC(Date d);
    @Query(value = "select * from contrat where date_debutc<:date",nativeQuery = true)//SQL
    List<Contrat>selectByDateDebutCSQL(@Param("date") Date d);
///afficher la list des contrats des etudiant ==> domaine="SE",nom="ben mohamed"
    //-->jointure
    @Query(value="select * from contrat c join etudiant e on"+
            " c.etud_id_etudiant=e.id_etudiant where e.domaine=?2 and e.nome=?1",nativeQuery= true)
    List<Contrat>selectJointureSQL(String nom , Domaine d);
    @Query("select c from Contrat c, Etudiant e where c.etud.idEtudiant=e.idEtudiant and e.nomE=?1 and e.domaine=?2")
    List<Contrat>selectJointureJPQL(String nom ,Domaine d);
//*********************************************//*****updete*****//******************************************/////////
//modifier la specialite du contrat dont la dateDebut<2022-2-2
    @Transactional
    @Modifying
    @Query(value = "update contrat set specialite=:s where date_debutc<:d ",nativeQuery = true)
    void updateContratSQL(@Param("d") Date datedebut,@Param("s") Specialite spec);
    @Transactional
    @Modifying
    @Query("update Contrat set specialite=?2 where  dateDebutC<?1")
    void updateContratJPQL(Date datedebutc,Specialite spec);
}
