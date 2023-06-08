package JAVAU2W2D4.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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

import JAVAU2W2D4.entities.Città;
import JAVAU2W2D4.payloads.CittàRegistrationPayload;
import JAVAU2W2D4.services.CittàService;

@RestController
@RequestMapping("/citta")
public class CittàController {
	@Autowired
	private CittàService cittaService;

	@GetMapping("")
	public Page<Città> getCitta(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		return cittaService.find(page, size, sortBy);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Città saveCitta(@RequestBody @Validated CittàRegistrationPayload body) {
		return cittaService.create(body);
	}

	@GetMapping("/{cittaId}")
	public Città getCitta(@PathVariable UUID cittaId) throws Exception {
		return cittaService.findById(cittaId);
	}

	@PutMapping("/{cittaId}")
	public Città updateCitta(@PathVariable UUID cittaId, @RequestBody Città body) throws Exception {
		return cittaService.findByIdAndUpdate(cittaId, body);
	}

	@DeleteMapping("/{cittaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCitta(@PathVariable UUID cittaId) {
		cittaService.findByIdAndDelete(cittaId);
	}
}
