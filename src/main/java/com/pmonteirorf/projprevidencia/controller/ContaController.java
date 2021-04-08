package com.pmonteirorf.projprevidencia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {
	

	/*@Autowired
	private ContaRepository contaRepository;
		
	@GetMapping
	public ContaDto exibirSaldo(Long beneficiario) {		
		Conta conta = contaRepository.findByBeneficiario_Id(beneficiario);
		return new ContaDto(conta);
	}
	
	@RequestMapping("/aporte")
	@PostMapping
	public ContaDto realizarAporte(Long beneficiario, Double valorAporte) {					
		Conta conta = contaRepository.findByBeneficiario_Id(beneficiario);
		conta.setSaldo(conta.getSaldo() + valorAporte);
		conta.setValorAposentadoria(conta.getSaldo() / conta.getPeriodoBeneficio());	
		
		// salvar novo saldo
		contaRepository.saveAndFlush(conta);
		
		return new ContaDto(conta);
	}*/

}
