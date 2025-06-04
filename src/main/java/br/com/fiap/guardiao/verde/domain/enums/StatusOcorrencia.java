package br.com.fiap.guardiao.verde.domain.enums;

public enum StatusOcorrencia {
	
	PENDENTE(1),
	EM_ANALISE(2),
	CONCLUIDA(3);
	
	private final int status;
	
	StatusOcorrencia(int status){
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
}
