BEGIN;

-- CLEAR
DROP TABLE IF EXISTS sensient_creature CASCADE;
DROP TABLE IF EXISTS natural_object CASCADE;
DROP TABLE IF EXISTS emotion CASCADE;
DROP TABLE IF EXISTS event CASCADE;
DROP TABLE IF EXISTS reason CASCADE;
DROP TABLE IF EXISTS reason_object CASCADE;
DROP TABLE IF EXISTS reason_emotion CASCADE;
DROP TABLE IF EXISTS reason_event CASCADE;
DROP TABLE IF EXISTS participation CASCADE;
DROP TABLE IF EXISTS setting CASCADE;
DROP TABLE IF EXISTS reaction CASCADE;
DROP TABLE IF EXISTS action CASCADE;
DROP TABLE IF EXISTS thought CASCADE;

DROP TYPE IF EXISTS level CASCADE;

-- CREATE TYPES
CREATE TYPE level as ENUM ('L', 'M', 'H');

-- CREATE DATA BASE
CREATE TABLE sensient_creature(
	id serial PRIMARY KEY,
	type varchar(70) NOT NULL,
	description text
	);
CREATE TABLE natural_object(
	id serial PRIMARY KEY,
	type varchar(70) NOT NULL,
	characteristic text,
	effect text
	);
CREATE TABLE emotion(
	id serial PRIMARY KEY,
	type varchar(70) NOT NULL,
	intensity level NOT NULL,
	creature_id int NOT NULL REFERENCES sensient_creature(id)
	);
CREATE TABLE event(
	id serial PRIMARY KEY,
	title text NOT NULL,
	data date NOT NULL,
	description text
	);
CREATE TABLE reason(
	id serial PRIMARY KEY,
	type varchar(70) NOT NULL
	);
CREATE TABLE reason_object(
	id int PRIMARY KEY REFERENCES reason(id),
	object_id int NOT NULL REFERENCES natural_object(id)
	);
CREATE TABLE reason_emotion(
	id int PRIMARY KEY REFERENCES reason(id),
	emotion_id int NOT NULL REFERENCES emotion(id)
	);
CREATE TABLE reason_event(
	id int PRIMARY KEY REFERENCES reason(id),
	event_id int NOT NULL REFERENCES event(id)
	);
CREATE TABLE participation(
	id serial PRIMARY KEY,
	creature_id int NOT NULL REFERENCES sensient_creature(id),
	event_id int NOT NULL REFERENCES event(id),
	role text NOT NULL
	);
CREATE TABLE setting(
	id serial PRIMARY KEY,
	object_id int NOT NULL REFERENCES natural_object(id),
	event_id int NOT NULL REFERENCES event(id),
	effect_type varchar(70) NOT NULL
	);
CREATE TABLE thought(
	id serial PRIMARY KEY,
	content text NOt NULL,
	complexity level NOT NULL,
	creature_id int NOT NULL REFERENCES sensient_creature(id),
	reason_id int NOT NULL REFERENCES reason(id)
	);
CREATE TABLE action(
	id serial PRIMARY KEY,
	description text NOT NULL,
	thought_id int NOT NULL REFERENCES thought(id)
	);
CREATE TABLE reaction(
	id serial PRIMARY KEY,
	action_id int NOT NULL REFERENCES action(id),
	emotion_id int NOT NULL REFERENCES emotion(id)
	);

-- INSERT DATA
INSERT INTO sensient_creature(type, description) VALUES
	('Человек', 'Обычный человек'),
	('Пришелец', 'Человекоподобный гуманоид'),
	('Эльф', 'Лесной остроухий народ'),
	('Дракон', 'Крылатое огнедышащее существо');
INSERT INTO natural_object(type, characteristic, effect) VALUES
	('Солнце', 'Черное', 'Дает энергию'),
	('Дуб', 'Могучий и высокий', 'Дает мудрость'),
	('Река', 'Быстрая и горная', 'Очищает энергию'),
	('Гора', 'Каменная', 'Вдохновляет на свершения');
INSERT INTO event(title, data, description) VALUES
	('Восход Черного Солнца', '2025-01-01', 'Да будет свет!'),
	('Праздник Весны', '2023-05-01', 'Пробуждение природы'),
	('Битва за Перевал', '2023-07-15', 'Великое сражение'),
	('Совет Мудрецов', '2023-01-01', 'Заседание ГосДумы');
INSERT INTO reason(type) VALUES
	('Природный объект'),
	('Эмоция'),
	('Событие');
INSERT INTO emotion(type, intensity, creature_id) VALUES
	('Радость', 'H', 1),
	('Испуг', 'M', 2),
	('Гнев', 'L', 3);
INSERT INTO participation(creature_id, event_id, role) VALUES
	(1, 1, 'Организатор'),
	(2, 2, 'Подручный'),
	(3, 3, 'Мальчик на побегушках');
INSERT INTO setting(object_id, event_id, effect_type) VALUES
	(1, 1, 'Задает вайб'),
	(2, 2, 'Замедляет продвижение'),
	(3, 3, 'Усиливает концентрацию');
INSERT INTO reason_object(id, object_id) VALUES
	(1, 1);
INSERT INTO reason_emotion(id, emotion_id) VALUES
	(2, 2);
INSERT INTO reason_event(id, event_id) VALUES
	(3, 3);
INSERT INTO thought(content, complexity, creature_id, reason_id) VALUES
	('Как прекрасен этот мир!', 'H', 1, 1),
	('Нужно работать', 'M', 2, 2),
	('Устал жить', 'L', 3, 3);
INSERT INTO action(description, thought_id) VALUES
	('Зажечь костер', 1),
	('Уволиться', 2),
	('Заплакать', 3);
INSERT INTO reaction(action_id, emotion_id) VALUES
	(1, 1),
	(2, 2),
	(3, 3);
	
END;
