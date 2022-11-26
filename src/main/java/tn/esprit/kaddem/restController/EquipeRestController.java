package tn.esprit.kaddem.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.services.EquipeService;

import java.util.List;

@RestController
public class EquipeRestController {
@Autowired
    EquipeService eqs;
    @PostMapping("/addEquipe")
    public Equipe ajouterEquipe(@RequestBody Equipe e) {

        return eqs.ajouterEquipe(e);
    }
    @PostMapping("/addEquipes")
    public List<Equipe> ajouterEquipes(@RequestBody List<Equipe> equipe){

        return eqs.ajouterEquipes(equipe);
    }
    @GetMapping("/findEquipebyid")
    Equipe findById(@RequestParam long id){

        return eqs.recupereEquipeAvecId((int) id);
    }
    @GetMapping("/listEquipe")
    public List<Equipe> recupereEquipe(){

        return eqs.recupereEquipe();
    }
    @DeleteMapping("/deleteEquipe")
    public void supprimerEquipe(@RequestBody Equipe c){

        eqs.supprimerEquipe(c);
    }
    @DeleteMapping("/deleteEquipeId")
    public void supprimerEquipeAvecId(@RequestParam int idEquipe){

        eqs.supprimerEquipeAvecId((int) idEquipe);
    }
    @PutMapping("/modifierEquipe")
    public Equipe modifierEquipe(@RequestBody Equipe c){

        return eqs.modifierEquipe(c);
    }
    @PutMapping("/modifierEquipes")
    public List<Equipe> modifierEquipes(@RequestBody List<Equipe> Equipe){

        return eqs.modifierEquipes(Equipe);
    }
}
