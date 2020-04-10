create table Cliente_ArqServ (
codCliente int primary key identity,
nome varchar(50) not null,
telefone varchar(15) not null,
email varchar(30) not null,
cep varchar(9) not null,
numeroImovel int not null,
complemento varchar(50) not null
)

select * from Cliente_ArqServ

drop table Cliente_ArqServ

alter table Cliente_ArqServ
nocheck constraint chkCEP_ArqServ

alter table Cliente_ArqServ
add constraint chkCEP_ArqServ check(cep like '[0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9]')

alter table Cliente_ArqServ
add constraint chkTelefone_ArqServ check (telefone like '([0-9][0-9]) [0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]')

insert into Cliente_ArqServ values ('José Bonifácio de Almeida', '(11) 12345-5432', 'joseba@gmail.com', '11111-999', 10, 'Residencial Fazenda de Olímpia')