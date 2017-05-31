package io.codetour.domain.curso;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import io.codetour.domain.aluno.Aluno;
import io.codetour.domain.professor.Professor;
import io.codetour.domain.curso.Curso;;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turma_sequence")
	@SequenceGenerator(name = "turma_sequence", allocationSize = 1, sequenceName = "turma_sequence")
	private Long id;
	private String ano;
	@OneToOne
	private Professor professor;
	@ManyToMany
	private List<Aluno> alunos;
	@OneToOne
	private Curso curso;

	public Turma() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
