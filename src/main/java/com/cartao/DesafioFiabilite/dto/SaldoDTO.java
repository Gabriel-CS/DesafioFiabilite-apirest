package com.cartao.DesafioFiabilite.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaldoDTO {
		
	private Long saldoDisponivel;
}

