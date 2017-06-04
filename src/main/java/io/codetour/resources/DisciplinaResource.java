package io.codetour.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codetour.domain.curso.Disciplina;
import io.codetour.domain.curso.DisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	private DisciplinaRepository disciplinaRepository;

	public DisciplinaResource(DisciplinaRepository disciplinaRepository) {
		this.disciplinaRepository = disciplinaRepository;
	}

	@GetMapping
	public Iterable<Disciplina> getAllDisciplinas() {
		return disciplinaRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Disciplina getDisciplina(@PathVariable Long id) {
		return disciplinaRepository.findOne(id);
	}

	@PostMapping
	public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	@PostMapping(value = "/{destrancar}/{id}")
	public boolean unlock(@PathVariable Long id) {
		lockUnlock(id, true);
		return true;
	}
	
	@PostMapping(value = "/{trancar}/{id}")
	public boolean lock(@PathVariable Long id) {
		lockUnlock(id, false);
		return true;
	}
	
	private void lockUnlock (Long id, Boolean status){
		Disciplina disciplina = disciplinaRepository.findOne(id);
		disciplina.setStatus(status);
		disciplinaRepository.save(disciplina);
	}//jogar esse metodo em uma classe de disciplina service

	@DeleteMapping(value = "/{id}")
	public void removeDisciplina(@PathVariable Long id) {
		disciplinaRepository.delete(id);
	}

}
