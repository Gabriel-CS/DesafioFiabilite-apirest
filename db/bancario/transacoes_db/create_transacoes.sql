create table bancario.transacoes(
	id bigserial not null,
	numero_cartao text not null,
	data_transacao timestamp not null,
	valor_transacao bigserial not null,
	tipo_transacao text not null,
	constraint pk_id_transacoes primary key(id)
);

alter table bancario.transacoes add constraint fk_numero_cartao foreign key(numero_cartao) references bancario.cartoes(numero_cartao);