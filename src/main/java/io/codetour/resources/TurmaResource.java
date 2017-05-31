	package io.codetour.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codetour.domain.curso.Turma;
import io.codetour.domain.curso.TurmaRepository;

@RestController
@RequestMapping("/turma")
public class TurmaResource {

	private TurmaRepository turmaRepository;

	public TurmaResource(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}

	@GetMapping
	public Iterable<Turma> getAllTurmas() {
		return turmaRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Turma getTurma(@PathVariable Long id) {
		return turmaRepository.findOne(id);
	}

	@PostMapping
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}

	@DeleteMapping(value = "/{id}")
	public void removeTurma(@PathVariable Long id) {
		turmaRepository.delete(id);
	}

}
