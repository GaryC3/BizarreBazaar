create table gamelist (
	gameid INT auto_increment,
	title VARCHAR(50),
	description TEXT,
	price DECIMAL(5,2),
	inventory INT,
	genre VARCHAR(12)
);

create table discount (
	genre VARCHAR(50),
	discount DECIMAL(3,2)
);

create table userlist (
	id INT auto_increment,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(50),
	password VARCHAR(50) not null
);

create table users (
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(50) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username, authority);

create table invoice (
	invoice_id INT auto_increment,
	id INT,
	gameid INT
);

create table invoiceLines (
	line_id INT auto_increment,
	id INT,
	gameid INT
);