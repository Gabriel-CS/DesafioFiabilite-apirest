package com.cartao.DesafioFiabilite.mapper;

import org.springframework.stereotype.Component;

import com.cartao.DesafioFiabilite.dto.CartaoDTO;
import com.cartao.DesafioFiabilite.models.Cartao;

@Component
public class CartaoMapper {

	public CartaoDTO map(Cartao cartao) {
		return CartaoDTO.builder()
				.id(cartao.getId())
				.numeroCartao(cartao.getNumeroCartao())
				.dataValidade(cartao.getDataValidade())
				.build();
	}
	
}
