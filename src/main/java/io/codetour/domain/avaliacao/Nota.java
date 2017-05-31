package io.codetour.domain.avaliacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_sequence")
	@SequenceGenerator(name = "nota_sequence", sequenceName = "nota_sequence")
	private Long id;

	
}
