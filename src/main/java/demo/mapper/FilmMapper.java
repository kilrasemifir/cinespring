package demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import demo.models.Film;

public class FilmMapper implements RowMapper<Film> {

	@Override
	public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
		Film film = new Film();
		film.setId(rs.getLong("film_id"));
		return film;
	}

}
