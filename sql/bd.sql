create database IF NOT EXISTS mailsystem;

use mailsystem;

create table IF NOT EXISTS users (
	id BIGINT NOT NULL AUTO_INCREMENT,
	login varchar(30) not null unique key,
	name varchar(30) not null,
	PRIMARY KEY (id)
) ENGINE=INNODB;