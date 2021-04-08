package com.pmonteirorf.projprevidencia.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.pmonteirorf.projprevidencia.modelo.Beneficiario;

public class BeneficiarioDto {

	private Long id;
	private String nome;
	private Long cpf;
	private String email;
	private int periodoBeneficio; 
	private Double saldo;
	private Double valorAposentadoria;
		
	public BeneficiarioDto(Beneficiario beneficiario) {
		super();
		this.id = beneficiario.getId();
		this.nome = beneficiario.getNome();
		this.cpf = beneficiario.getCpf();
		this.email = beneficiario.getEmail();
		this.periodoBeneficio = beneficiario.getConta().getPeriodoBeneficio();
		this.saldo = beneficiario.getConta().getSaldo();
		this.valorAposentadoria = beneficiario.getConta().getValorAposentadoria();
	}
	
	public String getNome() {
		return nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}		
	public Long getId() {
		return id;
	}
	public int getPeriodoBeneficio() {
		return periodoBeneficio;
	}	
	public Double getSaldo() {
		return saldo;
	}
	public Double getValorAposentadoria() {
		return valorAposentadoria;
	}
	public static List<BeneficiarioDto> converter(List<Beneficiario> beneficiarios) {
		return beneficiarios.stream().map(BeneficiarioDto::new).collect(Collectors.toList());
	}	
}
