create table familia(
                        id uuid not null primary key,
                        nome varchar(30)
);

create table membro(
                        id uuid not null primary key,
                        nome varchar(50) not null,
                        email varchar(30) not null unique,
                        data_nascimento date,
                        senha varchar(25) not null,
                        perfil varchar(20) not null,
                        id_familia uuid not null,
                        foreign key (id_familia) references familia(id)
);

create table despesa(
                        id uuid not null primary key,
                        descricao varchar(50) not null,
                        valor decimal not null,
                        data_vencimento date not null,
                        visibilidade varchar(20) not null,
                        id_membro uuid not null,
                        foreign key (id_membro) references membro(id)
);