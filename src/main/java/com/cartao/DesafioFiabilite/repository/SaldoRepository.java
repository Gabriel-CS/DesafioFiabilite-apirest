package com.cartao.DesafioFiabilite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartao.DesafioFiabilite.models.Saldo;

public interface SaldoRepository extends JpaRepository<Saldo, Long>{

	Optional<Saldo> findByNumeroCartao(String numeroCartao);
	
}


