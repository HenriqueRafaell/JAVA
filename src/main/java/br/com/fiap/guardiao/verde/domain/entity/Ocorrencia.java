package br.com.fiap.guardiao.verde.domain.entity;

import java.util.Date;

import br.com.fiap.guardiao.verde.domain.enums.StatusOcorrencia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "ocorrencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ocorrencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ocorrencia_seq")
	@SequenceGenerator(name = "ocorrencia_seq", sequenceName = "SEQ_OCORRENCIA", allocationSize = 1)
	@Column(name = "id_ocorrencia")
	private Long id;
	private Date dataOcorrencia;
    @Enumerated(EnumType.ORDINAL) 
	private StatusOcorrencia status;
	@ManyToOne
    @JoinColumn(name = "id_local")
	private Localizacao localizacao;
	
}
