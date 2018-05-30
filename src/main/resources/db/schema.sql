drop table training_club if exists ;
CREATE TABLE IF NOT EXISTS training_club (
  id INT NOT NULL,
  name VARCHAR(255) NULL,
  description VARCHAR(255) NULL,
  thumbnail_url VARCHAR(255) NULL,
  PRIMARY KEY (id)
);
drop table training_club_user if exists ;
create table IF NOT EXISTS training_club_user (
  id int not null primary key,
  username varchar(255) not null unique ,
  password varchar(255) not null
);
drop table training_club_user_clubs if exists ;
create table IF NOT EXISTS training_club_user_clubs (
  training_club_id int not null ,
  training_club_user_id int not null ,
  primary key (training_club_id,training_club_user_id),
  foreign key(training_club_id) references training_club(id),
  foreign key(training_club_user_id) references training_club_user(id)
);
drop table test_paper if exists ;
CREATE TABLE IF NOT EXISTS test_paper (
  id INT NOT NULL,
  name VARCHAR(255) NULL,
  PRIMARY KEY (id)
);
drop table task_card if exists ;
CREATE TABLE IF NOT EXISTS task_card (
  id INT NOT NULL,
  name VARCHAR(255) NULL,
  description VARCHAR(255) NULL,
  icon VARCHAR(255) NULL,
  training_club_id INT,
  test_paper_id INT,
  PRIMARY KEY (id)
);
drop table doc if exists ;
CREATE TABLE IF NOT EXISTS doc (
  id INT NOT NULL,
  name VARCHAR(255) NULL,
  description VARCHAR(255) NULL,
  type INT NULL,
  url VARCHAR(255) NULL,
  task_card_id INT,
  PRIMARY KEY (id)
);
drop table question if exists ;
CREATE TABLE IF NOT EXISTS question (
  id INT NOT NULL,
  content VARCHAR(255) NULL,
  selection_a VARCHAR(255) NULL,
  selection_b VARCHAR(255) NULL,
  selection_c VARCHAR(255) NULL,
  selection_d VARCHAR(255) NULL,
  answer VARCHAR(15) NULL,
  test_paper_id INT,
  PRIMARY KEY (id)
);
drop table answer if exists ;
CREATE TABLE IF NOT EXISTS answer (
  id INT NOT NULL,
  answer VARCHAR(15) NULL,
  score INT NULL,
  question_id INT,
  trainee_id INT,
  test_paper_id INT,
  PRIMARY KEY (id)
);
drop table trainee_training_club if exists ;
CREATE TABLE IF NOT EXISTS trainee_training_club (
  id INT NOT NULL,
  trainee_id INT,
  training_clubcol_id INT,
  PRIMARY KEY (id)
);