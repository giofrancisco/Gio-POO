package io.codetour.domain.avaliacao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import io.codetour.domain.curso.Disciplina;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avaliacao_sequence")
	@SequenceGenerator(name = "avaliacao_sequence", sequenceName = "avaliacao_sequence")
	private Long id;
	@NotNull
	@OneToOne
	private Disciplina disciplina;
	private Boolean situacao;

	public Avaliacao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

}
