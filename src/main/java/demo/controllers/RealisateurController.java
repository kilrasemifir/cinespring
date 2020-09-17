package demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.models.Realisateur;
import demo.services.RealisateurService;

@RestController
@CrossOrigin
@RequestMapping("realisateurs")
public class RealisateurController {

	@Autowired
	private RealisateurService service;
	
	@GetMapping("")
	public List<Realisateur> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Realisateur findById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@PostMapping("")
	public Realisateur save(@RequestBody Realisateur entity) {
		return this.service.save(entity);
	}
}
