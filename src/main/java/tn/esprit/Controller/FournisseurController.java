package tn.esprit.Controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.model.Fournisseur;
import tn.esprit.services.FournisseurServiceImpl;


@RestController
@Api(tags = "Fournisseur Manager")
@RequestMapping("/api/fournisseur")
public class FournisseurController {
	
	
	@Autowired
	private FournisseurServiceImpl F;
	
	public FournisseurController(FournisseurServiceImpl F) {
		this.F=F;
	}

	
	@GetMapping("/AllFournisseur")
	@ApiOperation(value = "Get All Founisseur ")
	public List <Fournisseur> getAllFournisseur(){
		return F.getAllFournisseur();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Get Founisseur By Id  ")
	public Fournisseur findById(@PathVariable long id) {
		return F.getFournisseurById(id);
	}
	
	@PostMapping("/AddFournisseur")
	@ApiOperation(value = "Add Fournisseur")
	public String AddFournisseur(@RequestBody Fournisseur fournisseur) {
		F.addFournisseur(fournisseur);
		return "Fournisseur add successfully!!";
	}
	
	@PostMapping("/DeleteFournisseur/{id}")
	@ApiOperation(value = "Delete Fournisseur By Id ")
	public String DeleteFournisseur(@PathVariable long id) {
		F.DeleteFournisseur(id);
		return "Fournisseur Deleted successfully !!";
	}
	
    @PostMapping("/updateFournisseur/{id}")
	@ApiOperation(value = "Update Fournisseur By Id ")
    public String UpdateUser(@RequestBody Fournisseur fournisseur, @PathVariable long id){
    
        F.updateFournisseur(fournisseur,id);
        return "Fournisseur updated successfuly Don !!";
    }
    
    @PostMapping("/DeleteAllFournisseur")
	@ApiOperation(value = "Delete All Fournisseur ")
    public String DeleteAllFournisseur() {
    	F.DeleteAllFournisseur();
    	return "All Fournisseur are deleted successfully !!";
    }

	@GetMapping("assignFournisseurToProduit/{fournisseurId}/{produitId}")
	public String assignFournisseurToProduit(@PathVariable(value = "fournisseurId") long fournisseurId,@PathVariable(value = "produitId") long produitId){
		F.assignFournisseurToProduit(fournisseurId,produitId);
		return "Assigned Successfuly Don !";
	}
}
