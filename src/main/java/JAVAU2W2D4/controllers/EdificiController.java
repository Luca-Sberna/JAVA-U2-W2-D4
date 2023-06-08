package JAVAU2W2D4.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import JAVAU2W2D4.entities.Edificio;
import JAVAU2W2D4.services.EdificiService;

@RestController
@RequestMapping("/edifici")
public class EdificiController {
	@Autowired
	private EdificiService edificiService;

	@GetMapping("")
	public List<Edificio> getEdificios(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return edificiService.find(page, size, sortBy);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Edificio saveEdificio(@RequestBody Edificio body) {
		return edificiService.create(body);
	}

	@GetMapping("/{edificioId}")
	public Edificio getEdificio(@PathVariable UUID edificioId) throws Exception {
		return edificiService.findById(edificioId);
	}

	@PutMapping("/{edificioId}")
	public Edificio updateEdificio(@PathVariable UUID edificioId, @RequestBody Edificio body) throws Exception {
		return edificiService.findByIdAndUpdate(edificioId, body);
	}

	@DeleteMapping("/{edificioId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEdificio(@PathVariable UUID edificioId) throws Exception {
		edificiService.findByIdAndDelete(edificioId);
	}

}
