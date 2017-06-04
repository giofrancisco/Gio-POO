package io.codetour.domain.matricula;

import java.util.Collection;

import org.springframework.stereotype.Service;

import io.codetour.domain.curso.Disciplina;
import io.codetour.domain.curso.DisciplinaRepository;
import io.codetour.domain.historico.HistoricoRepository;

@Service
public class MatriculaService {

	private MatriculaRepository matriculaRepository;
	private DisciplinaRepository disciplinaRepository;
	private HistoricoRepository historicoRepository;

	public MatriculaService(
			MatriculaRepository matriculaRepository, 
			DisciplinaRepository disciplinaRepository,
			HistoricoRepository historicoRepository) {
		this.matriculaRepository = matriculaRepository;
		this.disciplinaRepository = disciplinaRepository;
		this.historicoRepository = historicoRepository;
	}
	
	public boolean fazerMatricula(Matricula matricula) {
		if(atendeDependencias(disciplinaRepository.findOne(matricula.getDisciplina().getId()).getDependencias())) {
			matriculaRepository.save(matricula);
			return true;
		} else {
			return false;
		}
	}	
	private boolean atendeDependencias(Collection<Disciplina> disciplinas) {
		return !historicoRepository.findByDisciplinaInAndAprovadoTrue(disciplinas).isEmpty();
	}	
}
