package com.cartao.DesafioFiabilite.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TipoTransacao {

	DEPOSITO("Deposito"),
	COMPRA("Compra");
	
	private final String descricao;
}
