package br.com.fiap.guardiao.verde.domain.enums;

public enum PrioridadeAlerta {
	
	BAIXA(1),
	MEDIA(2),
	ALTA(3);

	private final int nivel;
	
	PrioridadeAlerta(int nivel){
		this.nivel = nivel;
	}
	
	public int getNivel() {
		return nivel;
	}
}
