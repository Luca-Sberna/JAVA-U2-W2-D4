package JAVAU2W2D4.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Prenotazioni")
@Data
public class Prenotazione {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate data;

	@ManyToOne(cascade = CascadeType.ALL)
	private User utente;

	@ManyToOne(cascade = CascadeType.ALL)
	private Postazione postazione;

	public Prenotazione(UUID id, LocalDate data, User utente, Postazione postazione) {
		super();
		this.id = id;
		this.data = data;
		this.utente = utente;
		this.postazione = postazione;
	}

}
