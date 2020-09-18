package demo.repositories.custom;

import demo.models.Film;

public interface CustomFilmRepository {

	public Film searchFilm(String title);
}
