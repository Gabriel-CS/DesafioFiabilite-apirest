create table bancario.saldo_cartao(
	id bigserial not null,
	numero_cartao text not null,
	saldo_atual bigserial not null,
	ultima_atualizacao timestamp not null,
	constraint pk_id_saldo primary key (id)
);

alter table bancario.saldo_cartao add constraint fk_numero_cartao foreign key(numero_cartao) references bancario.cartoes(numero_cartao);