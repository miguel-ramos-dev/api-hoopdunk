
create table usuario(
	id int primary key auto_increment,
    nome varchar(45),
    nomePerfil varchar(20),
    email varchar(50),
    senha varchar(255),
    posicao varchar(15),
    nivel varchar(25),
    foto text,
    created_at datetime
);

create table seguidores(
	idSeguidor int,
    idSeguido int,
	dtHora datetime,
    primary key(idSeguidor, idSeguido),
    constraint fkseguidor_seguidores foreign key(idSeguidor) references usuario(id),
    constraint fkseguido_seguidores foreign key(idSeguido) references usuario(id)
);

create table post(
	id int primary key auto_increment,
    idUsuario int not null,
    descricao varchar(100),
    foto text,
    dtPost datetime
);
create table comentarioPost(
	id int primary key auto_increment,
	idPost int not null,
    idUsuario int not null,
    descricao varchar(100),
    fotoComentario text,
    created_at datetime,
    constraint fkpost_comentarioPost foreign key(idPost) references post(id),
    constraint fkusuario_comentarioPost foreign key(idUsuario) references usuario(id)
);


create table quadra(
	id int primary key auto_increment,
    nome varchar(30),
    foto text,
    nivel varchar(25),
    descricao varchar(300),
    localizacao varchar(50),
    created_at datetime
);


create table quadraJogadores(
	idQuadra int,
    idJogador int,
    tipoJogador varchar(20),
    primary key(idQuadra, idJogador),
    constraint chk_tipoJogador check(tipoJogador in('criador', 'jogador')),
	constraint fkquadra_quadraJogadores foreign key(idQuadra) references quadra(id),
    constraint fkjogador_quadraJogadores foreign key(idJogador) references usuario(id)
);

create table evento(
	id int primary key auto_increment,
    nome varchar(25),
    modalidade varchar(45),
    dtHoraComeco datetime,
    dtHoraEncerramento datetime,
    nivelJogo varchar(25),
    observacao varchar(255),
    idQuadra int,
    created_at datetime,
    constraint chk_dtHoraEncerramento check(dtHoraEncerramento > dtHoraComeco),
    constraint fkquadra_evento foreign key(idQuadra) references quadra(id)
);

create table eventoJogadores(
	idEvento int,
    idJogador int,
    tipoJogador varchar(20),
    primary key(idEvento, idJogador),
	constraint fkevento_eventoJogadores foreign key(idEvento) references evento(id),
    constraint fkjogador_eventoJogadores foreign key(idJogador) references usuario(id)
);