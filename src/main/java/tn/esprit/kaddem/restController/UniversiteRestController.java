package tn.esprit.kaddem.restController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Universite;
import tn.esprit.kaddem.services.UniversiteService;

import java.util.List;

@RestController
public class UniversiteRestController {
    @Autowired
    UniversiteService us;
    @PostMapping("/addUniversite")
    public Universite ajouterUniversite(@RequestBody /*Pour ajouter une list ou un objet in parametre*/ Universite u) {
        return us.ajouterUniversite(u);
    }
    @PostMapping("/addUniversites")
    public List<Universite> ajouterUniversites(@RequestBody List<Universite> universite){

        return us.ajouterUniversites(universite);
    }
    @GetMapping("/findUniversitebyid")
    Universite findById(@RequestParam long id){

        return us.recupereAvecId((int) id);
    }
    @GetMapping("/listUniversite")
    public List<Universite> recupereUniversite(){

        return us.recupereUniversite();
    }
    @DeleteMapping("/deleteUniversite")
    public void supprimerUniversite(@RequestBody Universite u){
        us.supprimerUniversite(u);
    }
    @DeleteMapping("/deleteUniversiteId")
    public void supprimerUniversiteAvecId(@RequestParam int idUniversite){

        us.supprimerUniversiteAvecId((int) idUniversite);
    }
    @PutMapping("/modifierUniversite")
    public Universite modifierUniversite(@RequestBody Universite u){

        return us.modifierUniversite(u);
    }
    @PutMapping("/modifierUniversites")
    public List<Universite> modifierUniversites(@RequestBody List<Universite> universite){
        return us.modifierUniversites(universite);
    }
    @PutMapping("/affecte")
    public void affecte(@RequestParam int idu, @RequestParam int idD){
        us.assignUniversiteToDepartement(idu,idD);
    }
}
