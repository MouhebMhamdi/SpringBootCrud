package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Rayon;
import tn.esprit.services.RayonServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api/Rayon")
public class RayonController {

	@Autowired
	RayonServiceImp R;
	
	public RayonController(RayonServiceImp R) {
		this.R=R;
	}
	
	@PostMapping("/AddRayon")
	public String AddRayon(Rayon rayon){
		R.addRayon(rayon);
		return("Rayon add don !!");
	}
	
	@PostMapping("/DeleteRayon/{id}")
	public String DeleteRayonByID (@PathVariable long id) {
		R.DeleteRayon(id);
		String s;
		s="Rayon " + id + " is deleted successfully";
		return s; 
	}
	
	@PostMapping("/DeleteAllRayon")
	public String DeleteAllRayon() {
		R.DeleteAllRayon();
		return "All Rayon are deleted successfully !!";
	}
	
	@GetMapping("{id}")
	public Rayon FindRayonByID(@PathVariable long id) {
		return R.getRayonById(id);
		
	}
	
	@GetMapping("/AllRayon")
	public List<Rayon> FindAllRayon() {
		return R.getAllRayon();
	}
}
