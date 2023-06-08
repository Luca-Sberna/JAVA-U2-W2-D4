package JAVAU2W2D4.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import JAVAU2W2D4.entities.Postazione;
import JAVAU2W2D4.exceptions.NotFoundException;
import JAVAU2W2D4.repositories.PostazioniRepository;

@Service
public class PostazioniService {
	@Autowired
	private PostazioniRepository postazioniRepo;

	public Postazione create(Postazione p) {
//logica custom addizionale
		return postazioniRepo.save(p);
	}

	public List<Postazione> find() {
		return postazioniRepo.findAll();
	}

	public Postazione findByDescrizioneIgnoreCase(String descrizione) throws NotFoundException {
		return postazioniRepo.findByDescrizioneIgnoreCase(descrizione);
	}

	public Postazione findById(UUID id) throws Exception {
		return postazioniRepo.findById(id).orElseThrow(() -> new Exception("postazione non trovata"));
	}

	public Postazione findByIdAndUpdate(UUID id, Postazione p) throws Exception {
		Postazione found = this.findById(id);
		found.setDescrizione(p.getDescrizione());
		found.setTipo(p.getTipo());
		found.setMaxOccupanti(p.getMaxOccupanti());
		found.setEdificio(p.getEdificio());
		found.setPrenotazioni(p.getPrenotazioni());
		return postazioniRepo.save(found);

	}

	public void findByIdAndDelete(UUID id) throws Exception {
		Postazione found = this.findById(id);
		postazioniRepo.delete(found);
	}

	public long count() {
		return postazioniRepo.count();
	}

	public List<Postazione> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sortBy));
		return postazioniRepo.findAll(pageable).getContent();
	}
}
