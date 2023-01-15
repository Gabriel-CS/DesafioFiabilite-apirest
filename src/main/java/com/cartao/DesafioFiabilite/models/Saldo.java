package com.cartao.DesafioFiabilite.models;

import java.time.LocalDateTime;

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
@Table(name = "saldo_cartao", schema = "bancario")
@Entity
public class Saldo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="saldo_atual")
	private Long valorDisponivel;
	
	@Column(name="numero_cartao")
	private String numeroCartao;
	
	@Column(name="ultima_atualizacao")
	private LocalDateTime ultimaAtualizacao;
	}
