package com.cartao.DesafioFiabilite.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoDTO {
	
	private Long id;
	private String numeroCartao;
	private long saldo;
	private String dataValidade;
	
}
