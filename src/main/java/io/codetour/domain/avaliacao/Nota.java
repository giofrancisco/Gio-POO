package io.codetour.domain.avaliacao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import io.codetour.domain.aluno.Aluno;

@Entity
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_sequence")
	@SequenceGenerator(name = "nota_sequence", sequenceName = "nota_sequence")
	private Long id;
	@ManyToOne
	private Aluno aluno;
	@ManyToOne
	private Avaliacao avaliacao;
	private float nota;

	public Nota() {
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

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

}
