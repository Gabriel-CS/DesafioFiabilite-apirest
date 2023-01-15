package com.cartao.DesafioFiabilite.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cartao.DesafioFiabilite.dto.CartaoDTO;
import com.cartao.DesafioFiabilite.dto.SaldoDTO;
import com.cartao.DesafioFiabilite.dto.TransacaoRequestDTO;
import com.cartao.DesafioFiabilite.enums.TipoTransacao;
import com.cartao.DesafioFiabilite.mapper.CartaoMapper;
import com.cartao.DesafioFiabilite.mapper.SaldoMapper;
import com.cartao.DesafioFiabilite.models.Cartao;
import com.cartao.DesafioFiabilite.models.Saldo;
import com.cartao.DesafioFiabilite.models.Transacao;
import com.cartao.DesafioFiabilite.repository.CartaoRepository;
import com.cartao.DesafioFiabilite.repository.SaldoRepository;
import com.cartao.DesafioFiabilite.repository.TransacaoRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Service
public class CartaoService {

	private final CartaoRepository cartaoRepository;
	private final TransacaoRepository transacaoRepository;
	private final SaldoRepository saldoRepository;

	private final CartaoMapper cartaoMapper;
	private final SaldoMapper saldoMapper;

	public CartaoDTO cadastrar(Cartao cartao) {
		
			Saldo saldoInicial = Saldo.builder()
					.numeroCartao(cartao.getNumeroCartao())
					.valorDisponivel(0L)
					.ultimaAtualizacao(LocalDateTime.now())
					.build();
					
					cartaoRepository.save(cartao);
					saldoRepository.save(saldoInicial);
					
					return cartaoMapper.map(cartao);
		
	}

	public SaldoDTO buscaSaldoCartao(String numeroCartao) {

		Optional<Saldo> saldoEntity = saldoRepository.findByNumeroCartao(numeroCartao);

		return saldoMapper.map(saldoEntity.get());
	}

	public void depositoCartao(TransacaoRequestDTO transacaoRequestDTO) {

		Optional<Cartao> cartaoOpt = cartaoRepository.findByNumeroCartao(transacaoRequestDTO.getNumeroCartao());

		Optional<Saldo> saldoAtualOpt = saldoRepository.findByNumeroCartao(cartaoOpt.get().getNumeroCartao());

		Long novoSaldo = transacaoRequestDTO.getValorTransacao() + saldoAtualOpt.get().getValorDisponivel();

		
		Saldo saldoBuilder = Saldo.builder()
				.id(saldoAtualOpt.get().getId())
				.numeroCartao(transacaoRequestDTO.getNumeroCartao())
				.ultimaAtualizacao(LocalDateTime.now())
				.valorDisponivel(novoSaldo)
				.build();
		
		Transacao transacaoBuilder = Transacao.builder().numeroCartao(cartaoOpt.get().getNumeroCartao())
				.valorTransacao(transacaoRequestDTO.getValorTransacao()).dataTransacao(LocalDateTime.now())
				.tipoTransacao(TipoTransacao.DEPOSITO.getDescricao()).build();

		transacaoRepository.save(transacaoBuilder);
		
		saldoRepository.saveAndFlush(saldoBuilder);
	}

	public void saqueCartao(TransacaoRequestDTO transacaoRequestDTO) throws Exception {
		
		Optional<Cartao> cartaoOpt = cartaoRepository.findByNumeroCartao(transacaoRequestDTO.getNumeroCartao());
		
		Optional<Saldo> saldoAtualOpt = saldoRepository.findByNumeroCartao(cartaoOpt.get().getNumeroCartao());
		
		Long saldoAtual = saldoAtualOpt.get().getValorDisponivel();
		Long saldoSaque = transacaoRequestDTO.getValorTransacao();
		Long novoSaldo = null;
		
		if(saldoSaque > saldoAtual) {
			throw new Exception("Saldo Insuficiente! Saldo Disponível: ".concat(saldoAtual.toString()));
		}else if ( saldoSaque <= saldoAtual) {
			novoSaldo = saldoAtual - saldoSaque;
		}
		
		Saldo saldoBuilder = Saldo.builder()
				.id(saldoAtualOpt.get().getId())
				.numeroCartao(transacaoRequestDTO.getNumeroCartao())
				.ultimaAtualizacao(LocalDateTime.now())
				.valorDisponivel(novoSaldo)
				.build();	 	
		 
		  Transacao transacaoBuilder = Transacao.builder()
				  .numeroCartao(transacaoRequestDTO.getNumeroCartao())
				  .valorTransacao(transacaoRequestDTO.getValorTransacao())
				  .dataTransacao(LocalDateTime.now())
				  .tipoTransacao(TipoTransacao.COMPRA.getDescricao()) .build();
		  		  
		  transacaoRepository.save(transacaoBuilder);
		  
	 	  saldoRepository.saveAndFlush(saldoBuilder);
	}

	public List<Transacao> listaExtratoPorCartao(String numeroCartao) {
		 
		return transacaoRepository.findAllByNumeroCartao(numeroCartao);
	}
}
