package com.pmonteirorf.projprevidencia.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Conta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int periodoBeneficio; //quantidade em anos que o Beneficiários receberá o valor da aposentadoria
	private Double saldo;
	private Double valorAposentadoria;
			
	
	public Conta() {
	}

	public Conta(int periodoBeneficio, Double saldo) {
		super();
		this.periodoBeneficio = periodoBeneficio;
		this.saldo = saldo;
		this.valorAposentadoria = saldo / periodoBeneficio;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public int getPeriodoBeneficio() {
		return periodoBeneficio;
	}
	public void setPeriodoBeneficio(int periodoBeneficio) {
		this.periodoBeneficio = periodoBeneficio;
	}
	public Double getValorAposentadoria() {
		return valorAposentadoria;
	}
	public void setValorAposentadoria(Double valorAposentadoria) {
		this.valorAposentadoria = valorAposentadoria;
	}
}
