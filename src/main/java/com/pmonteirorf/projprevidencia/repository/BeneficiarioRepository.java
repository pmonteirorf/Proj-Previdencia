package com.pmonteirorf.projprevidencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmonteirorf.projprevidencia.modelo.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

	List<Beneficiario> findByCpf(Long cpf);

}
