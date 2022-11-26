package tn.esprit.kaddem.restController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Domaine;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Specialite;
import tn.esprit.kaddem.services.ContratService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contrat")
@Tag(name="la gestion de contrat")
public class ContratRestController {
    @Autowired
    ContratService cs;

    @PostMapping("/addContrat")
    public Contrat ajouterContrat(@RequestBody  Contrat c) {

        return cs.ajouterContrat(c);
    }
    @PostMapping("/addContrats")
    public List<Contrat> ajouterContrats(@RequestBody List<Contrat> contrat){

        return cs.ajouterContrats(contrat);
    }
    @GetMapping("/findContratbyid")
    Contrat findById(@RequestParam long id){

        return cs.recupereContratAvecId((int) id);
    }
    @GetMapping("/listContrat")
    public List<Contrat> recupereContrat(){

        return cs.recupereContrat();
    }
    @DeleteMapping("/deleteContrat")
    public void supprimerContrat(@RequestBody Contrat c){

        cs.supprimerContrat(c);
    }
    @DeleteMapping("/deleteContratId")
    public void supprimerContratAvecId(@RequestParam int idContrat){

        cs.supprimerContratAvecId((int) idContrat);
    }
    @PutMapping("/modifierContrat")
    public Contrat modifierContrat(@RequestBody Contrat c){

        return cs.modifierContat(c);
    }
    @PutMapping("/modifierContrats")
    public List<Contrat> modifierContrats(@RequestBody List<Contrat> contrat){
        return cs.modifierContrats(contrat);
    }
    @Operation(description = "cette methode recupere la list des contrats dont la datedebut est"+"inferieur a la date passe en parametre")
    @GetMapping("selectbydatedebut")
     List<Contrat> selecteddateContrat(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date d){

        return cs.recupererListContratsSelonDate(d);
    }
    @GetMapping("/selectsql")
    List <Contrat> selectsql(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date d){

        return cs.selectsql(d);
    }
    @GetMapping("/selectjoinsql")
    List<Contrat> selectJoinSQL(String nom, Domaine domaine){
        return cs.selectJoinSQL(nom,domaine);
    }
    @GetMapping("/selectjoinjpql")
    public List<Contrat> selectJoinJPQL(String nom,Domaine d){
        return cs.selectJoinJPQL(nom,d);
    }
    @Operation()
    @PutMapping("/updatecontratsql")
    public void updatecontratSQL( @DateTimeFormat(pattern = "yyyy-MM-dd")Date date,  Specialite spec){

        cs.updatecontratSQL(date,spec);
    }
    @PutMapping("/updatecontratjpql")
    public void updatecontratJPQL(@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd")Date d,Specialite s){

        cs.updatecontratJPQL(d,s);
    }
    @PostMapping("/addAndAsign")
    public Etudiant addAndAssignEtudiantToEandC(@RequestBody Etudiant e,@RequestParam Integer idContrat,@RequestParam Integer idEquipe) {
      return cs.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);

    }
    @PutMapping("/affectecontratetudiant")
    public Contrat affectCToE(@RequestBody Contrat ce,@RequestParam String nomE,@RequestParam String prenomE) {
        return cs.affectContratToEtudiant(ce, nomE, prenomE);

    }
}
