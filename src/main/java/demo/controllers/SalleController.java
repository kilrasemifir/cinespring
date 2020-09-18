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

import demo.models.Salle;
import demo.services.SalleService;

@RestController
@CrossOrigin
@RequestMapping("salles")
public class SalleController {

	@Autowired
	private SalleService service;
	
	@GetMapping("")
	public List<Salle> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Salle findById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@PostMapping("")
	public Salle save(@RequestBody Salle entity) {
		return this.service.save(entity);
	}

}
