package io.codetour.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codetour.domain.curso.Semestre;
import io.codetour.domain.curso.SemestreRepository;

@RestController
@RequestMapping("/semestre")
public class SemestreResource {

	private SemestreRepository semestreRepository;

	public SemestreResource(SemestreRepository semestreRepository) {
		this.semestreRepository = semestreRepository;
		
	}
	
	@PostMapping
	public Semestre createSemestre(@RequestBody Semestre semestre) {
		return semestreRepository.save(semestre);
	}
	
	@GetMapping
	public Iterable<Semestre> getAllSemestres() {
		return semestreRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Semestre getSemestre(@PathVariable Long id) {
		return semestreRepository.findOne(id);
	}
	
	@PutMapping(value = "/{id}")
	public Semestre updateSemestre(@PathVariable Long id, @RequestBody Semestre semestre) {
		return semestreRepository.save(semestre);
	}
	
	@DeleteMapping(value = "/{id}")
	public void removeSemestre(@PathVariable Long id) {
		semestreRepository.delete(id);
	}
	
}
