create table bancario.cartoes(
	id bigserial not null,
	numero_cartao text not null,
	cvv int not null,
	data_validade text not null,
	constraint pk_numero_cartao primary key (numero_cartao)
);