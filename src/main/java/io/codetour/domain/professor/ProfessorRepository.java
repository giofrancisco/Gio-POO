package io.codetour.domain.professor;

import org.springframework.data.repository.CrudRepository;

import io.codetour.domain.professor.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long>{
	public Professor findByNome(String nome);
}
