package com.cartao.DesafioFiabilite.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortadorDTO {

	private int id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	
}
