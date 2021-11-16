package tn.esprit.Controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Facture;
import tn.esprit.services.FactureServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/facture")
@Api(tags = "Facture Manager")
public class FactureController {
    @Autowired
    FactureServiceImpl factureService;

    @GetMapping("/getFactureByClient/{idClient}")
    List<Facture> getFactureByClient(@PathVariable(value = "idClient") long idClient){
        return factureService.getFacturesByClient(idClient);
    }

    @PostMapping("/addFacture/{idClient}")
    Facture addFacutre(@RequestBody Facture facture ,@PathVariable(value = "idClient") long idClient){
        return factureService.addFacture(facture,idClient);
    }



}
