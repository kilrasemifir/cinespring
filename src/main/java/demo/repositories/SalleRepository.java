package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.models.Salle;

public interface SalleRepository extends JpaRepository<Salle, Long>{

}
