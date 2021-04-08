package com.pmonteirorf.projprevidencia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pmonteirorf.projprevidencia.controller.dto.BeneficiarioDto;
import com.pmonteirorf.projprevidencia.controller.form.AporteForm;
import com.pmonteirorf.projprevidencia.controller.form.BeneficiarioForm;
import com.pmonteirorf.projprevidencia.modelo.Beneficiario;
import com.pmonteirorf.projprevidencia.repository.BeneficiarioRepository;
import com.pmonteirorf.projprevidencia.repository.ContaRepository;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiariosController {
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository; 
	
	@Autowired
	private ContaRepository contaRepository; 

	@GetMapping
	public List<BeneficiarioDto> lista(Long cpf) {		
		if(cpf == null) {
			List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();
			return BeneficiarioDto.converter(beneficiarios);
		}else {
			List<Beneficiario> beneficiarios = beneficiarioRepository.findByCpf(cpf);
			return BeneficiarioDto.converter(beneficiarios);
		}		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<BeneficiarioDto> cadastrar(@RequestBody BeneficiarioForm form, UriComponentsBuilder uriBuilder) {
		Beneficiario beneficiario = form.converter(contaRepository);
		beneficiarioRepository.save(beneficiario);
		URI uri = uriBuilder.path("/beneficiarios/{id}").buildAndExpand(beneficiario.getId()).toUri();
		return ResponseEntity.created(uri).body(new BeneficiarioDto(beneficiario));
	}
	
	@PostMapping
	@Transactional
	@RequestMapping("/aporte")
	public ResponseEntity<BeneficiarioDto> realizarAporte(@RequestBody AporteForm form, UriComponentsBuilder uriBuilder) {
		Beneficiario beneficiario = form.converter(contaRepository, beneficiarioRepository);
		beneficiarioRepository.save(beneficiario);
		URI uri = uriBuilder.path("/beneficiarios/{id}").buildAndExpand(beneficiario.getId()).toUri();
		return ResponseEntity.created(uri).body(new BeneficiarioDto(beneficiario));
	}
}
