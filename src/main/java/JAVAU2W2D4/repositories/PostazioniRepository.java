package JAVAU2W2D4.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import JAVAU2W2D4.entities.Postazione;

public interface PostazioniRepository extends JpaRepository<Postazione, String> {

	Postazione findByDescrizioneIgnoreCase(String descrizione);

	Optional<Postazione> findById(UUID id);
}
