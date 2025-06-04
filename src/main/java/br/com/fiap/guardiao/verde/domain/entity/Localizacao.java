package br.com.fiap.guardiao.verde.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "localizacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local_seq")
	@SequenceGenerator(name = "local_seq", sequenceName = "SEQ_LOCALIZACAO", allocationSize = 1)
	@Column(name = "id_local")
	private Long id;
    @Column(name = "nome_local")
	private String nomeLocal;
	private double latitude;
	private double longitude;

}
