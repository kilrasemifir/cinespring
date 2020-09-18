package demo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NoArgsConstructor;

@Entity
//@Table(name = "films")
@NoArgsConstructor
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "film_id")
	private Long id;
	
	@Column(name = "titre", 
			length = 64, 
			nullable = false,
			unique = true)
	private String titre;
	
	@Column(name = "description", 
			columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "duree", 
			nullable = false)
	private Integer duree;
	
	@Column(name = "date_sortie", 
			columnDefinition = "DATE", 
			nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@Column(name = "save_at", 
			columnDefinition = "DATE")
	private LocalDate saveAt;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Exploitation exploitation;
	
	@ManyToOne
	@JoinColumn(name="realisateur_id")
	private Realisateur realisateur;
	
	@ManyToMany
	@JoinTable(
			name = "salle_film",
			joinColumns = @JoinColumn(name = "film_id"),
			inverseJoinColumns = @JoinColumn(name = "salle_id"))
	private List<Salle> salles = new ArrayList<>();
	
	public void setSaveAt(LocalDate date) {
		this.saveAt = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Exploitation getExploitation() {
		return exploitation;
	}

	public void setExploitation(Exploitation exploitation) {
		this.exploitation = exploitation;
	}

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	public LocalDate getSaveAt() {
		return saveAt;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
	
}
