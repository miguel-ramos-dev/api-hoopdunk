create table usuario(
	id int primary key auto_increment,
    nome varchar(45),
    nome_perfil varchar(20),
    email varchar(50),
    senha varchar(255),
    posicao varchar(15),
    nivel varchar(25),
    foto text,
    created_at datetime
);