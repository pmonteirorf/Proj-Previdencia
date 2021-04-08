package com.pmonteirorf.projprevidencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmonteirorf.projprevidencia.modelo.Conta;


public interface ContaRepository extends JpaRepository<Conta, Long> {
	
}
