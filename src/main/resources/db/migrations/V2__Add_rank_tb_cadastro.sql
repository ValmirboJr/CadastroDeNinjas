-- V2: Migrations para adicionar a coluna rank

ALTER TABLE tb_cadastro
add column  rank varchar(255);