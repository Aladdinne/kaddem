package tn.esprit.kaddem.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.services.DepartementService;

import java.util.List;

@RestController
public class DepartementRestController {
    @Autowired
    DepartementService ds;
    @PostMapping("/addDepartement")
    public Departement ajouterDepartement(@RequestBody Departement d) {

        return ds.ajouterDepartement(d);
    }
    @PostMapping("/addDepartements")
    public List<Departement> ajouterDepartements(@RequestBody List<Departement> departement){

        return ds.ajouterDepartements(departement);
    }
    @GetMapping("/findDepartementbyid")
    Departement findById(@RequestParam long id){

        return ds.recupereDepartementAvecId((int) id);
    }
    @GetMapping("/listDepartement")
    public List<Departement> recupereDepartement(){

        return ds.recupereDepartement();
    }
    @DeleteMapping("/deleteDepartement")
    public void supprimerDepartement(@RequestBody Departement d){

        ds.supprimerDepartement(d);
    }
    @DeleteMapping("/deleteDepartementId")
    public void supprimerDepartementAvecId(@RequestParam int id){

        ds.supprimerDepartementAvecId((int) id);
    }
    @PutMapping("/modifierDepartement")
    public Departement modifierDepartement(@RequestBody Departement d){

        return ds.modifierDepartement(d);
    }
    @PutMapping("/modifierDepartemets")
    public List<Departement> modifierDepartements(@RequestBody List<Departement> departement){

        return ds.modifierDepartements(departement);
    }
}
