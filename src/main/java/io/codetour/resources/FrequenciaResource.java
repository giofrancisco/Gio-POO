package io.codetour.resources;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codetour.domain.avaliacao.Frequencia;
import io.codetour.domain.avaliacao.FrequenciaRepository;
import io.codetour.domain.avaliacao.FrequenciaService;


@RestController
@RequestMapping("/frequencias")
public class FrequenciaResource {

	private FrequenciaRepository frequenciaRepository;
	private FrequenciaService frequenciaService;

	public FrequenciaResource(FrequenciaRepository frequenciaRepository, FrequenciaService frequenciaService) {
		this.frequenciaRepository = frequenciaRepository;
		this.frequenciaService = frequenciaService;
	}

	@PostMapping(value = "/definirFrequencia/{id}/{frequencia}")
	public Boolean definirFrequencia(@PathVariable Long id, @PathVariable Long frequencia) {
		return frequenciaService.setarPresenca(frequencia);
	}

	@GetMapping(value = "/alunoId={alunoId}")
	public ArrayList<Frequencia> getByFrequenciaId(@PathVariable Long alunoId) {
		return frequenciaService.getFrequenciaBy(alunoId);
	}

	@GetMapping
	public Iterable<Frequencia> getAllFrequencias() {
		return frequenciaRepository.findAll();
	}

}
