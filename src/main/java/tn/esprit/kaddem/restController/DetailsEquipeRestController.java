package tn.esprit.kaddem.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.kaddem.entities.DetailsEquipe;
import tn.esprit.kaddem.services.DetailsEquipeService;

import java.util.List;

@RestController
public class DetailsEquipeRestController {
    @Autowired
    DetailsEquipeService des;
    @PostMapping("/addDetailsEquipe")
    public DetailsEquipe ajouterDetailsEquipe(@RequestBody DetailsEquipe c) {

        return des.ajouterDetailEquipe(c);
    }
    @PostMapping("/addDetailsEquipes")
    public List<DetailsEquipe> ajouterDetailsEquipes(@RequestBody List<DetailsEquipe> DetailsEquipe){

        return des.ajouterDetailEquipes(DetailsEquipe);
    }
    @GetMapping("/findDetailsEquipebyid")
    DetailsEquipe findById(@RequestParam long id){

        return des.recupereAvecId((int) id);
    }
    @GetMapping("/listDetailsEquipe")
    public List<DetailsEquipe> recupereDetailsEquipe(){

        return des.recupereDetailEquipe();
    }
    @DeleteMapping("/deleteDetailsEquipe")
    public void supprimerDetailsEquipe(@RequestBody DetailsEquipe c){

        des.supprimerDetailEquipe(c);
    }
    @DeleteMapping("/deleteDetailsEquipeId")
    public void supprimerDetailsEquipeAvecId(@RequestParam int idDetailsEquipe){

        des.supprimerDetailEquipeAvecId((int) idDetailsEquipe);
    }
    @PutMapping("/modifierDetailsEquipe")
    public DetailsEquipe modifierDetailsEquipe(@RequestBody DetailsEquipe c){

        return des.modifierDetailEquipe(c);
    }
    @PutMapping("/modifierDetailsEquipes")
    public List<DetailsEquipe> modifierDetailsEquipes(@RequestBody List<DetailsEquipe> DetailsEquipe){

        return des.modifierDetailEquipes(DetailsEquipe);
    }
}
