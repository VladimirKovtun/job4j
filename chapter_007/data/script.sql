Create database tasks;
\c tasks;

Create table state (
	id serial primary key,
	status varchar(50) not null
);

Create table category (
	id serial primary key,
	name varchar(50) not null
);

Create table role (
	id serial primary key,
	name varchar(50) not null
);

Create table rules (
	id serial primary key,
	rule varchar(100) not null
);

Create table role_to_rules (
	id serial primary key,
	role_id integer not null,
	rules_id integer not null,
	constraint role_id_fkey foreign key (role_id) references role(id),
	constraint rules_id_fkey foreign key (rules_id) references rules(id)
);

Create table users (
	id serial primary key,
	name varchar(100) not null,
	surname varchar(100) not null,
	role_id integer not null,
	constraint role_id_fkey foreign key (role_id) references role(id)
);

Create table items (
	id serial primary key,
	name varchar(100) not null,
	description text not null,
	user_id integer not null,
	category_id integer not null,
	state_id integer not null,
	constraint user_id_fkey foreign key (user_id) references users(id),
	constraint category_id_fkey foreign key (category_id) references category(id),
	constraint state_id_fkey foreign key (state_id) references state(id)
	
);

Create table comments (
	id serial primary key,
	description text not null, 
	items_id integer not null,
	constraint items_id_fkey foreign key (items_id) references items(id)
);

Create table attaches (
	id serial primary key,
	name varchar(100) not null,
	items_id integer not null,
	constraint items_id_fkey foreign key (items_id) references items(id)
);

	INSERT INTO category (name, id) VALUES ('первая категория', 1), ('вторая категория', 2);
    INSERT INTO state (status, id) VALUES ('выполнено', 3), ('в процессе', 2), ('не выполнен', 1);
	INSERT INTO role (name, id) VALUES ('Администратор', 1), ('Гость', 2), ('Рядовой работник', 3);
	INSERT INTO rules (rule, id) VALUES ('Все включено', 1), ('Частичный доступ', 2), ('Полный запрет', 3);
	INSERT INTO role_to_rules (role_id, rules_id) VALUES (1, 1), (2, 2), (2, 3), (3, 2), (3, 3);
	INSERT INTO users (name, surname, role_id) VALUES ('Первый', 'Пользователь', 3), ('Второй', 'Пользователь', 1);
	INSERT INTO items (name, description, user_id, category_id, state_id) VALUES
	 													 ('Заявка от чайника', 'Вообще ничего не работает, комп перезагружал', 1, 1, 2), ('Заявка на комп', 'Собрать новый компьютер', 1, 2, 1), ('Всего по немногу', 'нужно уточнить', 2, 2, 2);
    INSERT INTO comments (description, items_id) VALUES ('комментарий 1', 1), ('комментарий 2', 3), ('комментарий 3', 2), ('комментарий 4', 2);
	INSERT INTO attaches (name, items_id) VALUES ('Текстовый файл', 1), ('фотография 1', 1), ('видеофайл', 2), ('Аудио файл', 3);
	
	
	

	
	




	