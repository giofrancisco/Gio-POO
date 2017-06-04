package io.codetour.domain.avaliacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import io.codetour.domain.aluno.Aluno;
import io.codetour.domain.curso.Disciplina;

@Entity
public class Frequencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "frequencia_sequence")
	@SequenceGenerator(name = "frequencia_sequence", sequenceName = "frequencia_sequence")
	private Long id;
	@ManyToOne
	private Aluno aluno;
	@ManyToOne
	private Disciplina disciplina;
	private int frequencia;

	public Frequencia() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

}
