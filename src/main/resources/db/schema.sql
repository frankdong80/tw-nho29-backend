create table if not exists nho_user(
  id number,
  username varchar(100),
  password varchar(100)
);

CREATE TABLE IF NOT EXISTS training_club (
  id INT NOT NULL,
  name VARCHAR(255) NULL,
  description VARCHAR(255) NULL,
  teacherName VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS test_paper (
  id INT NOT NULL,
  name VARCHAR(255) NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE IF NOT EXISTS task_card (
    id INT NOT NULL,
    name VARCHAR(255) NULL,
    description VARCHAR(255) NULL,
    icon VARCHAR(255) NULL,
    training_club_id INT,
    test_paper_id INT,
    PRIMARY KEY (id));

    CREATE TABLE IF NOT EXISTS doc (
      id INT NOT NULL,
      name VARCHAR(255) NULL,
      url VARCHAR(255) NULL,
      task_card_id INT,
      PRIMARY KEY (id));
      
    CREATE TABLE IF NOT EXISTS question (
      id INT NOT NULL,
      content VARCHAR(255) NULL,
      selection_a VARCHAR(255) NULL,
      selection_b VARCHAR(255) NULL,
      selection_c VARCHAR(255) NULL,
      selection_d VARCHAR(255) NULL,
      answer VARCHAR(15) NULL,
      test_paper_id INT,
      PRIMARY KEY (id));

    CREATE TABLE IF NOT EXISTS answer (
      id INT NOT NULL,
      answer VARCHAR(15) NULL,
      score INT NULL,
      question_id INT,
      trainee_id INT,
      test_paper_id INT,
      PRIMARY KEY (id));
      
     CREATE TABLE IF NOT EXISTS trainee_training_club (
      id INT NOT NULL,
      trainee_id INT,
      training_clubcol_id INT,
      PRIMARY KEY (id));