package com.pmonteirorf.projprevidencia.controller.form;

import java.util.Optional;

import com.pmonteirorf.projprevidencia.modelo.Beneficiario;
import com.pmonteirorf.projprevidencia.modelo.Conta;
import com.pmonteirorf.projprevidencia.repository.BeneficiarioRepository;
import com.pmonteirorf.projprevidencia.repository.ContaRepository;

public class AporteForm {
	
	private Long idBeneficiario;
	private Double valorAporte;
	
	public Long getIdBeneficiario() {
		return idBeneficiario;
	}
	public void setIdBeneficiario(Long idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}
	public Double getValorAporte() {
		return valorAporte;
	}
	public void setValorAporte(Double valorAporte) {
		this.valorAporte = valorAporte;
	}
	
	public Beneficiario converter(ContaRepository contaRepository, BeneficiarioRepository beneficiarioRepository) {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(idBeneficiario);
		Optional<Conta> conta = contaRepository.findById(beneficiario.get().getConta().getId().longValue());
		conta.get().setSaldo(conta.get().getSaldo() + valorAporte);
		conta.get().setValorAposentadoria(conta.get().getSaldo() / conta.get().getPeriodoBeneficio());
		Conta contaAtualizada = contaRepository.save(conta.get());
		beneficiario.get().setConta(contaAtualizada);
		
		return beneficiario.get();
	}
}
