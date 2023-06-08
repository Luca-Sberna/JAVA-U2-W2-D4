package JAVAU2W2D4.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import JAVAU2W2D4.entities.Edificio;

public interface EdificiRepository extends JpaRepository<Edificio, Long> {
	Optional<Edificio> findByNomeIgnoreCase(String name);

	Optional<Edificio> findById(UUID id);
}
