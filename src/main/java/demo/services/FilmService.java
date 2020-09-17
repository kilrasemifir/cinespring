package demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import demo.models.Film;
import demo.repositories.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository repository;
	
	public List<Film> findAll(){
		return this.repository.findAll();
	}
	
	public Film save(Film entity) {
	    entity.setSaveAt(LocalDate.now());;
		try {
			return this.repository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	public Film findById(Long id) {
		// retourne un Status 400 si aucun film ne perte l'id donné en param
		return this.repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
