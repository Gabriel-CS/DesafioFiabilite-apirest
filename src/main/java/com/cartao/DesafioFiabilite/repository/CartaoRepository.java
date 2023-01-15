package com.cartao.DesafioFiabilite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartao.DesafioFiabilite.models.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	
	public Optional<Cartao> findByNumeroCartao(String numeroCartao);
}
