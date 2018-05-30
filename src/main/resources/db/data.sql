insert into training_club_user(id, username, password) values (1,'admin','admin');
insert into training_club(id, `name`, description, thumbnail_Url) values (1, 'Java训练营', '熟悉Java开发','thumbnail_Url');
insert into training_club(id, `name`, description, thumbnail_Url) values (2, '前端训练营', '熟悉前端设计和开发','thumbnail_Url');
insert into training_club(id, `name`, description, thumbnail_Url) values (3, 'DBA训练营', '熟悉和设计数据库','thumbnail_Url');

insert into training_club_user_clubs (training_club_id, training_club_user_id) values (1,1);
insert into training_club_user_clubs (training_club_id, training_club_user_id) values (2,1);