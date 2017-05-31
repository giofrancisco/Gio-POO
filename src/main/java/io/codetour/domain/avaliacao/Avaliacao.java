package io.codetour.domain.avaliacao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import io.codetour.domain.aluno.Aluno;
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
	@NotNull
	@OneToOne
	private Aluno aluno;
	@OneToMany
	private List<Nota> notas;
	@OneToMany
	private List<Frequencia> frequencias;
	private Boolean situacao;

	public Avaliacao() {}

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

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	

}
