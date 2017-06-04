package io.codetour.resources;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codetour.domain.curso.Turma;
import io.codetour.domain.professor.Professor;
import io.codetour.domain.professor.ProfessorRepository;
import io.codetour.domain.professor.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessoresResource {

	private ProfessorRepository professorRepository;
	private ProfessorService professorService;

	public ProfessoresResource(ProfessorRepository professorRepository, ProfessorService professorService) {
		this.professorService = professorService;
		this.professorRepository = professorRepository;
	}

	@GetMapping
	public Iterable<Professor> getAllProfessores() {
		return professorRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Professor getByName(@PathVariable Long id) {
		return professorRepository.findOne(id);
	}

	@GetMapping(value = "/profId={profId}")
	public ArrayList<Turma> getByProfId(@PathVariable Long profId) {
		return professorService.getTurmasBy(profId);
	}

	@PostMapping(value = "/alocation/{profId}/{turmaId}")
	public Boolean alocation(@PathVariable Long profId, @PathVariable Long turmaId) {
		return professorService.allocateIn(profId, turmaId);
	}

	@PostMapping(value = "/dealocation/{profId}/{turmaId}")
	public Boolean dealocation(@PathVariable Long profId, @PathVariable Long turmaId) {
		return professorService.deallocateIn(profId, turmaId);
	}

	@PostMapping
	public Professor saveProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}

	@PutMapping(value = "/{id}")
	public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
		return professorRepository.save(professor);
	}

	@DeleteMapping(value = "/{id}")
	public void removeProfessor(@PathVariable Long id) {
		professorRepository.delete(id);
	}

}
