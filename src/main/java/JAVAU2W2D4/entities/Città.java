package JAVAU2W2D4.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Città {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;

	public Città(String nome) {
		this.nome = nome;
	}
}
