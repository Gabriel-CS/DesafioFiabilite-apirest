package com.cartao.DesafioFiabilite.mapper;

import org.springframework.stereotype.Component;

import com.cartao.DesafioFiabilite.dto.TransacaoDTO;
import com.cartao.DesafioFiabilite.models.Transacao;

@Component
public class TransacaoMapper {

	public TransacaoDTO map (Transacao transacao) {
		return TransacaoDTO.builder()
				.idTransacao(transacao.getId())
				.valorTransacao(transacao.getValorTransacao())
				.dataTransacao(transacao.getDataTransacao())
				.tipoTransacao(transacao.getTipoTransacao())
				.build();
	}
	
}
