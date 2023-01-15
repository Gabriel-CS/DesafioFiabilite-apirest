package com.cartao.DesafioFiabilite.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="cartoes", schema="bancario")
@Entity(name = "cartao")
public class Cartao{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numero_cartao")
	private String numeroCartao;
	
	@Column(name="data_validade")
	private String dataValidade;
	
	@Column(name="cvv")
	private int cvv;
	
	

}
