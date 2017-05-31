package io.codetour.domain.avaliacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Frequencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "frequencia_sequence")
	@SequenceGenerator(name = "frequencia_sequence", sequenceName = "frequencia_sequence")
	private Long id;

}
