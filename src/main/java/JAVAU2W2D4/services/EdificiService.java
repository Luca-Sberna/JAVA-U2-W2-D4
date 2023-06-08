package JAVAU2W2D4.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import JAVAU2W2D4.entities.Edificio;
import JAVAU2W2D4.exceptions.NotFoundException;
import JAVAU2W2D4.repositories.EdificiRepository;

@Service
public class EdificiService {
	@Autowired
	private EdificiRepository edificiRepo;

	public Edificio create(Edificio e) {
//logica custom addizionale
		return edificiRepo.save(e);
	}

	public List<Edificio> find() {
		return edificiRepo.findAll();
	}

	public Edificio findByNameIgnoreCase(String nome) throws NotFoundException {
		return edificiRepo.findByNomeIgnoreCase(nome).orElseThrow(() -> new NotFoundException(nome));
	}

	public Edificio findById(UUID id) throws Exception {
		return edificiRepo.findById(id).orElseThrow(() -> new Exception("edificio non trovato"));
	}

	public Edificio findByIdAndUpdate(UUID id, Edificio e) throws Exception {
		Edificio found = this.findById(id);
		found.setId(e.getId());
		found.setNome(e.getNome());
		found.setIndirizzo(e.getIndirizzo());
		found.setCitta(e.getCitta());
		return edificiRepo.save(found);

	}

	public void findByIdAndDelete(UUID id) throws Exception {
		Edificio found = this.findById(id);
		edificiRepo.delete(found);
	}

	public long count() {
		return edificiRepo.count();
	}

	public List<Edificio> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sortBy));
		return edificiRepo.findAll(pageable).getContent();
	}
}
