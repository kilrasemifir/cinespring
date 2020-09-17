package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class GenericService<T> {

	@Autowired
	private JpaRepository<T, Long> repository;
	
	public List<T> findAll(){
		return this.repository.findAll();
	}
	
	public T save(T entity) {
		try {
			return this.repository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	public T findById(Long id) {
		// retourne un Status 400 si aucun film ne perte l'id donné en param
		return this.repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}
}
