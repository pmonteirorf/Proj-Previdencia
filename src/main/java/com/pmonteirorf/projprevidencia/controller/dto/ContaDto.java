package com.pmonteirorf.projprevidencia.controller.dto;

import com.pmonteirorf.projprevidencia.modelo.Conta;

public class ContaDto {

	private Double saldoAtual;
	private Double valorMensalAposentadoria;

	public ContaDto(Conta conta) {
		super();
		this.saldoAtual = conta.getSaldo();
	}

	public Double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public Double getValorMensalAposentadoria() {
		return valorMensalAposentadoria;
	}

	public void setValorMensalAposentadoria(Double valorMensalAposentadoria) {
		this.valorMensalAposentadoria = valorMensalAposentadoria;
	}
	
}
