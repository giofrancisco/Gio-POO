package io.codetour.domain.avaliacao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import io.codetour.domain.curso.Disciplina;
import io.codetour.domain.curso.DisciplinaRepository;


@Service
public class AvaliacaoService {
	
	private DisciplinaRepository disciplinaRepository;
	private AvaliacaoRepository avaliacaoRepository;
	private FrequenciaService frequenciaService;
	private NotaService notaService;
	
	

	public AvaliacaoService(DisciplinaRepository disciplinaRepository, AvaliacaoRepository avaliacaoRepository,
			FrequenciaService frequenciaService, NotaService notaService) {
		this.disciplinaRepository = disciplinaRepository;
		this.avaliacaoRepository = avaliacaoRepository;
		this.frequenciaService = frequenciaService;
		this.notaService = notaService;
	}

	public ArrayList<Avaliacao> getAvaliacaoBy(Long disciplinaId) {
		Disciplina disciplina = disciplinaRepository.findOne(disciplinaId);
		Iterable<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
		ArrayList<Avaliacao> result = new ArrayList<>();
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.getDisciplina().equals(disciplina)) {
				result.add(avaliacao);
			}
		}
		return result;
	}
	
	public int validarFrequencia(Long alunoId, Long disciplinaId ){
		int quantidadeAvaliacoes=0;
		float somarNotas=0f;
		float calculo=0f;
		Disciplina disciplina = disciplinaRepository.findOne(disciplinaId);
		ArrayList<Frequencia> frequencias = frequenciaService.getFrequenciaBy(alunoId);
		ArrayList<Nota> notas = notaService.getNotasBy(alunoId);
		for(Frequencia frequencia:frequencias){
			if (frequencia.getDisciplina().equals(disciplina)){
				if(frequencia.getFrequencia()<4){
					return 0;
				}
			}
		}
		for (Nota nota:notas){
			if(nota.getAvaliacao().getDisciplina().equals(disciplina)){
				quantidadeAvaliacoes++;
				somarNotas+=nota.getNota();
			}
		}
		
		calculo = somarNotas/quantidadeAvaliacoes;
		
		if (calculo <=3f){
			return 0;
		} else if (calculo <=7f){
			return 1;
		}else{
			return 2;
		}
		
	}
}
