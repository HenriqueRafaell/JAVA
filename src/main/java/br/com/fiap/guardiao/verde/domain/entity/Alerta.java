package br.com.fiap.guardiao.verde.domain.entity;

import java.util.Date;

import br.com.fiap.guardiao.verde.domain.enums.PrioridadeAlerta;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alerta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alerta {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_ocorrencia")
	private Ocorrencia ocorrencia;
	private Date dataEnvio;
    @Enumerated(EnumType.ORDINAL)
	private PrioridadeAlerta prioridade;
	
}
