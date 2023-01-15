package com.cartao.DesafioFiabilite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartao.DesafioFiabilite.models.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	List<Transacao> findAllByNumeroCartao(String numeroCartao);
	
}
