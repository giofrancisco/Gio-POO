package io.codetour.resources;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codetour.domain.avaliacao.Avaliacao;
import io.codetour.domain.avaliacao.AvaliacaoRepository;
import io.codetour.domain.avaliacao.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoResource {

	private AvaliacaoRepository avaliacaoRepository;
	private AvaliacaoService avaliacaoService;

	@GetMapping(value = "/disciplinaId={disciplinaId}")
	public ArrayList<Avaliacao> getByAvaliacaoId(@PathVariable Long disciplinaId) {
		return avaliacaoService.getAvaliacaoBy(disciplinaId);
	}

	@GetMapping
	public Iterable<Avaliacao> getAllAvaliacoes() {
		return avaliacaoRepository.findAll();
	}
	
	

}
