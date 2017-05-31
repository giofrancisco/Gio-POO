package io.codetour.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codetour.domain.curso.Curso;
import io.codetour.domain.curso.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursosResource {

	private CursoRepository cursoRepository;
	public CursosResource(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	@GetMapping
	public Iterable<Curso> getAllCursos() {
		return cursoRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Curso getCurso(@PathVariable Long id) {
		return cursoRepository.findOne(id);
	}
	
	@PostMapping 
	public Curso createCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@DeleteMapping(value="/{id}")
	public void removeCurso(@PathVariable Long id) {
		cursoRepository.delete(id);
	}
}
