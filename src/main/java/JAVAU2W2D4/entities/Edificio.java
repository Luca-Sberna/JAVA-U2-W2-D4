package JAVAU2W2D4.entities;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "edifici")
@Data
public class Edificio {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String indirizzo;

	@ManyToOne(cascade = CascadeType.ALL)
	private Città citta;

	public Edificio(String nome, String indirizzo, Città citta) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

}
