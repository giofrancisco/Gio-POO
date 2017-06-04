package io.codetour.domain.avaliacao;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import io.codetour.domain.aluno.Aluno;
import io.codetour.domain.aluno.AlunoRepository;

@Service
public class NotaService {

	private NotaRepository notaRepository;
	private AlunoRepository alunoRepository;

	public NotaService(NotaRepository notaRepository, AlunoRepository alunoRepository) {
		this.notaRepository = notaRepository;
		this.alunoRepository = alunoRepository;
	}

	public ArrayList<Nota> getNotasBy(Long alunoId) {
		Aluno aluno = alunoRepository.findOne(alunoId);
		Iterable<Nota> notas = notaRepository.findAll();
		ArrayList<Nota> result = new ArrayList<>();
		for (Nota nota : notas) {
			if (nota.getAluno().equals(aluno)) {
				result.add(nota);
			}
		}
		return result;
	}

	public Boolean definirNota(Long notaId, float nota) {
		Nota notas = notaRepository.findOne(notaId);
		notas.setNota(nota);
		notaRepository.save(notas);
		return true;

	}
}
