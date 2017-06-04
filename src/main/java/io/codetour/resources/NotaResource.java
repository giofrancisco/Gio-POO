package io.codetour.resources;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.codetour.domain.avaliacao.Nota;
import io.codetour.domain.avaliacao.NotaRepository;
import io.codetour.domain.avaliacao.NotaService;



@RestController
@RequestMapping("/notas")
public class NotaResource {

	private NotaRepository notaRepository;
	private NotaService notaService;

	public NotaResource(NotaRepository notaRepository) {
		this.notaRepository = notaRepository;
	}
	
	@PostMapping(value = "/definirNota/{id}/{nota}")
	public Boolean definirNota(@PathVariable Long id, @PathVariable float nota) {
		return notaService.definirNota(id, nota);
	}
	
	@GetMapping(value = "/alunoId={alunoId}")
	public ArrayList<Nota> getByAlunoId(@PathVariable Long alunoId) {
		return notaService.getNotasBy(alunoId);
	}

	@GetMapping
	public Iterable<Nota> getAllNotas() {
		return notaRepository.findAll();
	}
	
	
	


}
