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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="transacoes", schema="bancario")
@Entity
public class Transacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numero_cartao")
	private String numeroCartao;
	
	@Column(name="valor_transacao")
	private Long valorTransacao;
	
	@Column(name="data_transacao")
	private LocalDateTime dataTransacao;
	
	@Column(name="tipo_transacao")
	private String tipoTransacao;
	
}
