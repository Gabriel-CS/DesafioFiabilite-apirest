package com.cartao.DesafioFiabilite.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cartao.DesafioFiabilite.dto.CartaoDTO;
import com.cartao.DesafioFiabilite.dto.SaldoDTO;
import com.cartao.DesafioFiabilite.dto.TransacaoRequestDTO;
import com.cartao.DesafioFiabilite.models.Cartao;
import com.cartao.DesafioFiabilite.models.Transacao;
import com.cartao.DesafioFiabilite.service.CartaoService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Controller
@RestController
@RequestMapping("/cartao")
public class CartaoController {

	private final CartaoService cartaoService;
	
	@PostMapping
	public ResponseEntity<CartaoDTO> cadastroCartao(@RequestBody Cartao cartao, HttpServletResponse response) {
		CartaoDTO cartaoCadastrado = cartaoService.cadastrar(cartao);
		return ResponseEntity.status(HttpStatus.CREATED).body(cartaoCadastrado);
	}

	@GetMapping("/saldo/{numeroCartao}")
	public ResponseEntity<SaldoDTO> obterSaldo(@PathVariable String numeroCartao) {
		SaldoDTO saldoDTO = cartaoService.buscaSaldoCartao(numeroCartao);
				
		return !Objects.isNull(saldoDTO) ? ResponseEntity.ok().body(saldoDTO)
				: ResponseEntity.notFound().build();
	}
	
	@PutMapping("/deposito")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void depositar(@RequestBody TransacaoRequestDTO transacaoRequestDTO) {
		cartaoService.depositoCartao(transacaoRequestDTO);
		
	}
	
	@PutMapping("/saque")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void sacar(@RequestBody TransacaoRequestDTO transacaoRequestDTO) throws Exception {
		cartaoService.saqueCartao(transacaoRequestDTO);
			
	}
	
	@GetMapping("/extrato/{numeroCartao}")
	public List<Transacao> obterExtrato(@PathVariable String numeroCartao) {
					
		return cartaoService.listaExtratoPorCartao(numeroCartao);
				
	}

}