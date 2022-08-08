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
	password VARCHAR(50)
);

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