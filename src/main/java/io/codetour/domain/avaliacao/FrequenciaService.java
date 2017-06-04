package io.codetour.domain.avaliacao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import io.codetour.domain.aluno.Aluno;
import io.codetour.domain.aluno.AlunoRepository;

@Service
public class FrequenciaService {

	private FrequenciaRepository frequenciaRepository;
	private AlunoRepository alunoRepository;

	public FrequenciaService(FrequenciaRepository frequenciaRepository) {
		this.frequenciaRepository = frequenciaRepository;
	}

	public ArrayList<Frequencia> getFrequenciaBy(Long alunoId) {
		Aluno aluno = alunoRepository.findOne(alunoId);
		Iterable<Frequencia> frequencias = frequenciaRepository.findAll();
		ArrayList<Frequencia> result = new ArrayList<>();
		for (Frequencia frequencia : frequencias) {
			if (frequencia.getAluno().equals(aluno)) {
				result.add(frequencia);
			}
		}
		return result;
	}

	public Boolean setarPresenca(Long frequenciaid) {
		Frequencia frequencia = frequenciaRepository.findOne(frequenciaid);
		frequencia.setFrequencia(frequencia.getFrequencia() + 1);
		frequenciaRepository.save(frequencia);
		return true;
	}

}
