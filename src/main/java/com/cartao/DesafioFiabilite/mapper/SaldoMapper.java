package com.cartao.DesafioFiabilite.mapper;

import org.springframework.stereotype.Component;

import com.cartao.DesafioFiabilite.dto.SaldoDTO;
import com.cartao.DesafioFiabilite.models.Saldo;
@Component
public class SaldoMapper {

	public SaldoDTO map(Saldo saldo) {
		return SaldoDTO.builder().
				saldoDisponivel(saldo.getValorDisponivel())
				.build();
	}

}
