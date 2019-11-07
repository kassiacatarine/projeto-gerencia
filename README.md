# projeto-gerencia

## Operações no banco de dados

$sudo su postgres 				//alternar para o usuario postgres
$psql						//entrar no banco administrativo
#alter user postgres with password 'postgres';	//modificar a senha do usuario postgres
#create database gcdb				//criar o banco de dados
#\q						//sair do banco administrativo

$psql gcdb			//ingressar no banco gcdb
#CREATE TABLE public.cidade
(
  codigo integer NOT NULL,
  nome character varying(60),
  CONSTRAINT pk_cid PRIMARY KEY (codigo)
);
#\q

## Deploy do Projeto

Acessar o servidor via ssh:

    ssh {username}@10.20.19.7
    - {senha}

Enviar os arquivos para o servidor:

    scp {nomeArquivo} {username}@10.20.19.7:

Executar o arquivo no endereço 10.20.19.7:

    java -jar payara-micro-5.193.jar cli1.war --addLibs postgresql-42.2.5.jre7.jar

Acessar o site:

    10.20.19.7:8080/cli1