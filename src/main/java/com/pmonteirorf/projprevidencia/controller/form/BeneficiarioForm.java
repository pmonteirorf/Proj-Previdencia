package com.pmonteirorf.projprevidencia.controller.form;

import com.pmonteirorf.projprevidencia.modelo.Beneficiario;
import com.pmonteirorf.projprevidencia.modelo.Conta;
import com.pmonteirorf.projprevidencia.repository.ContaRepository;

public class BeneficiarioForm {
	
	private String nome;
	private Long cpf;
	private String email;
	private int periodoBeneficio;
	private Double saldoAposentadoria;
		
	public BeneficiarioForm(String nome, Long cpf, String email, int periodoBeneficio, Double saldoAposentadoria) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.periodoBeneficio = periodoBeneficio;
		this.saldoAposentadoria = saldoAposentadoria;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPeriodoBeneficio() {
		return periodoBeneficio;
	}
	public void setPeriodoBeneficio(int periodoBeneficio) {
		this.periodoBeneficio = periodoBeneficio;
	}
	public Double getSaldoAposentadoria() {
		return saldoAposentadoria;
	}
	public void setSaldoAposentadoria(Double saldoAposentadoria) {
		this.saldoAposentadoria = saldoAposentadoria;
	}
	
	public Beneficiario converter(ContaRepository contaRepository) {
		Conta novaConta = new Conta(periodoBeneficio, saldoAposentadoria);
		Conta contaCriada = contaRepository.save(novaConta);
		return new Beneficiario(nome, cpf, email, contaCriada);
	}
}
