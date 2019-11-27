Create database car_catalog;

\c car_catalog;

CREATE table carcass (
	id serial primary key,
	name varchar(200) not null
);

CREATE table engine (
	id serial primary key,
	name varchar(200) not null
);

CREATE table transmission (
	id serial primary key,
	name varchar(200) not null
);

CREATE table car (
	id serial primary key,
	name varchar(200) not null,
	carcass_id integer unique not null,
	engine_id integer unique not null,
	transmission_id integer unique not null,
	constraint transmission_id_fk foreign key (transmission_id) references transmission(id),
	constraint engine_id_fk foreign key (engine_id) references engine(id),
	constraint carcass_id_fk foreign key (carcass_id) references carcass(id)
);

INSERT into carcass (name) values
		('carcass1'),
		('carcass2'),
		('carcass3'),
		('carcass4'),
		('carcass5'
);

INSERT into engine (name) values
		('engine1'),
		('engine2'),
		('engine3'),
		('engine4'
);

INSERT into transmission (name) values
		('transmission1'),
		('transmission2'),
		('transmission3'),
		('transmission4'),
		('transmission5'),
		('transmission6'
);

INSERT into car (name, transmission_id, engine_id, carcass_id) values
		('car1', 5, 1, 4),
		('car2', 1, 4, 3),
		('car3', 3, 2, 1
);














