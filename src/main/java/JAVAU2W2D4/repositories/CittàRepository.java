package JAVAU2W2D4.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JAVAU2W2D4.entities.Città;

@Repository
public interface CittàRepository extends JpaRepository<Città, UUID> {
	Optional<Città> findByNomeIgnoreCase(String nome);

}