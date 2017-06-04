package io.codetour.domain.matricula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import io.codetour.domain.aluno.Aluno;
import io.codetour.domain.curso.Disciplina;

@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_sequence")
	@SequenceGenerator(name = "matricula_sequence", sequenceName = "matricula_sequence")
	private Long id;
	@ManyToOne
	@NotNull
	private Aluno aluno;
	@ManyToOne
	@NotNull
	private Disciplina disciplina;

	Matricula() {
	}

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

}
