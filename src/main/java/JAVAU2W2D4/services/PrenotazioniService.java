package JAVAU2W2D4.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import JAVAU2W2D4.entities.Prenotazione;
import JAVAU2W2D4.repositories.PrenotazioniRepository;

@Service
public class PrenotazioniService {
	@Autowired
	private PrenotazioniRepository prenotazioniRepo;

	public Prenotazione create(Prenotazione p) {
//logica custom addizionale
		return prenotazioniRepo.save(p);
	}

	public List<Prenotazione> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sortBy));
		return prenotazioniRepo.findAll(pageable).getContent();
	}

	public Prenotazione findById(UUID id) throws Exception {
		return prenotazioniRepo.findById(id).orElseThrow(() -> new Exception("prenotazione non trovato"));
	}

	public Prenotazione findByIdAndUpdate(UUID id, Prenotazione p) throws Exception {
		Prenotazione found = this.findById(id);
		found.setId(p.getId());
		found.setData(p.getData());
		found.setPostazione(p.getPostazione());
		found.setUtente(p.getUtente());
		return prenotazioniRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws Exception {
		Prenotazione found = this.findById(id);
		prenotazioniRepo.delete(found);
	}

	public long count() {
		return prenotazioniRepo.count();
	}
}
