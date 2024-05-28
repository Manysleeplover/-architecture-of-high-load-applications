CREATE TABLE IF NOT EXISTS lecture
(
    id   INTEGER  PRIMARY KEY AUTO_INCREMENT,
    title varchar(256),
    text  text
);

CREATE TABLE IF NOT EXISTS imageData
(
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    name      varchar(256) not null,
    type      text,
    imageData bytea,
    lecture_id bigint,
    foreign key (lecture_id) references lecture(id)
);


insert into lecture (id, title, text) VALUES (1, 'Первая лекция', 'Первый текст');
insert into lecture (id, title, text) VALUES (2, 'Вторая лекция', 'Второй текст с изображением #test1q1/#');

