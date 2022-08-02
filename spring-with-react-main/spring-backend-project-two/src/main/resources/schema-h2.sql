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