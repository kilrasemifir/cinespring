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

import demo.models.Film;
import demo.services.FilmService;

@RestController
@CrossOrigin
@RequestMapping("films")
public class FilmController {

	@Autowired
	private FilmService service;
	
	@GetMapping("")
	public List<Film> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Film findById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@PostMapping("")
	public Film save(@RequestBody Film entity) {
		return this.service.save(entity);
	}
}
