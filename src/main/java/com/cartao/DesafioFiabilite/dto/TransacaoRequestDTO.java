package com.cartao.DesafioFiabilite.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TransacaoRequestDTO {

	private String numeroCartao;
	private Long valorTransacao;
}
