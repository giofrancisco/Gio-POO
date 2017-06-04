package io.codetour.domain.professor;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import io.codetour.domain.curso.Turma;
import io.codetour.domain.curso.TurmaRepository;

@Service
public class ProfessorService {

	private TurmaRepository turmaRepository;
	private ProfessorRepository professorRepository;

	public ProfessorService(TurmaRepository turmaRepository, ProfessorRepository professorRepository) {
		this.turmaRepository = turmaRepository;
		this.professorRepository = professorRepository;
	}

	public ArrayList<Turma> getTurmasBy(Long profId) {
		Professor professor = professorRepository.findOne(profId);
		Iterable<Turma> turmas = turmaRepository.findAll();
		ArrayList<Turma> result = new ArrayList<>();
		for (Turma turma : turmas) {
			if (turma.getProfessor().equals(professor)) {
				result.add(turma);
			}
		}
		return result;
	}

	public Boolean allocateIn(Long profId, Long turmaId) {
		Professor professor = professorRepository.findOne(profId);
		Turma turma = turmaRepository.findOne(turmaId);
		turma.setProfessor(professor);
		turmaRepository.save(turma);
		return true;
	}

	public Boolean deallocateIn(Long profId, Long turmaId) {
		Professor professor = professorRepository.findOne(profId);
		Turma turma = turmaRepository.findOne(turmaId);
		if (turma.getProfessor().equals(professor)) {
			turma.setProfessor(null);
			turmaRepository.save(turma);
			return true;
		}
		return false;
	}

}
