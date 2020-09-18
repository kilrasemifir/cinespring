package demo.repositories.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import demo.mapper.FilmMapper;
import demo.models.Film;
import demo.repositories.custom.CustomFilmRepository;

public class CustomFilmRepositoryImpl implements CustomFilmRepository {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public Film searchFilm(String titre) {
		String sql = "SELECT * FROM film WHERE titre = ?;";
		return this.template.queryForObject(sql, new FilmMapper(), titre);
	}

}
