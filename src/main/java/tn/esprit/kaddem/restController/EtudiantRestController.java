package tn.esprit.kaddem.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.services.IEtudiantService;

import java.util.List;

@RestController
public class EtudiantRestController {
    @Autowired
    IEtudiantService es;
    @PostMapping("/addetudiant")
    public Etudiant ajouterEtudiant(@RequestBody /*Pour ajouter une list ou un objet in parametre*/ Etudiant e) {
        return es.ajouterEtudiant(e);
    }
    @PostMapping("/addetudiants")
    public List<Etudiant> ajouterEtudiants(@RequestBody List<Etudiant> etudiant){

        return es.ajouterEtudiants(etudiant);
    }
    @GetMapping("/findbyid")
    Etudiant findById(@RequestParam long id){
        return es.recupereEtudiantAvecId((int) id);
    }
    @GetMapping("/listEtudiant")
    public List<Etudiant> recupereEtudiant(){
        return es.recupereEtudiant();
    }
    @DeleteMapping("/deleteEtudiant")
    public void supprimerEtudiant(@RequestBody Etudiant e){
        es.supprimerEtudiant(e);
    }
    @DeleteMapping("/deleteEtudiantId")
    public void supprimerEtudiantAvecId(@RequestParam int idEtudiant){
        es.supprimerEtudiantAvecId((int) idEtudiant);
    }
    @PutMapping("/modifierEtudiant")
    public Etudiant modifierEtudiant(@RequestBody Etudiant e){
        return es.modifierEtudiant(e);
    }
    @PutMapping("/modifierEtudiants")
    public List<Etudiant> modifierEtudiants(@RequestBody List<Etudiant> etudiant){
        return es.modifierEtudiants(etudiant);
    }
    @PutMapping("/affecteetudiantdepartement")
        public void affecte(@RequestParam int ide,@RequestParam int idD){

        es.assignEtudiantToDepartement(ide,idD);
    }

}
