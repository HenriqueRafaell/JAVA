package br.com.fiap.guardiao.verde.domain.entity;

import java.util.Date;

import br.com.fiap.guardiao.verde.domain.enums.PrioridadeAlerta;
import br.com.fiap.guardiao.verde.utils.PrioridadeAlertaConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alerta_seq")
	@SequenceGenerator(name = "alerta_seq", sequenceName = "alerta_seq", allocationSize = 1)
	@Column(name = "id_alerta")
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_ocorrencia")
	private Ocorrencia ocorrencia;
	private Date dataEnvio;
    @Convert(converter = PrioridadeAlertaConverter.class)
	private PrioridadeAlerta prioridade;
	
}
