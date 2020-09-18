package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.models.Film;
import demo.repositories.custom.CustomFilmRepository;

public interface FilmRepository extends JpaRepository<Film, Long>, CustomFilmRepository{

}
