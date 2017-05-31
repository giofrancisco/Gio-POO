package io.codetour.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codetour.domain.professor.Professor;
import io.codetour.domain.professor.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessoresResource {
	
private ProfessorRepository professorRepository;
	
	public ProfessoresResource(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}
	
	@GetMapping
	public Iterable<Professor> getAllProfessores() {
		return professorRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Professor getByName(@PathVariable Long id) {
		return professorRepository.findOne(id);
	}
	
	@PostMapping
	public Professor saveProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@PutMapping(value="/{id}")
	public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@DeleteMapping(value="/{id}")
	public void removeProfessor(@PathVariable Long id) {
		professorRepository.delete(id);
	}	

}
