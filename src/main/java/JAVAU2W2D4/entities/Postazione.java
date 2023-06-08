package JAVAU2W2D4.entities;

import java.util.List;
import java.util.UUID;

import JAVAU2W2D4.utils.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Postazioni")
@Data
public class Postazione {
	@Id
	@GeneratedValue
	private UUID id;
	private String descrizione;
	private TipoPostazione tipo;
	private int maxOccupanti;

	@ManyToOne
	private Edificio edificio;

	@OneToMany(mappedBy = "postazione")
	private List<Prenotazione> prenotazioni;

	public Postazione(UUID id, String descrizione, TipoPostazione tipo, int maxOccupanti, Edificio edificio,
			List<Prenotazione> prenotazioni) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.maxOccupanti = maxOccupanti;
		this.edificio = edificio;
		this.prenotazioni = prenotazioni;
	}

}
