package com.cartao.DesafioFiabilite.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {
	
	private Long idTransacao;
	private Long idCartao;
	private Long valorTransacao;
	private LocalDateTime dataTransacao;
	private String tipoTransacao;
	
}
