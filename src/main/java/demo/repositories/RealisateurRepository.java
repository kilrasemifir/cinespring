package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.models.Realisateur;

public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {

}
