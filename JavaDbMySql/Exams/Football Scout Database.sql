CREATE DATABASE fsd;
USE fsd;
CREATE TABLE countries(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL);

CREATE TABLE towns(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
country_id INT(11) NOT NULL,
CONSTRAINT fk_towns_countries
FOREIGN KEY towns(country_id)
REFERENCES countries(id));

CREATE TABLE stadiums(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
capacity INT(11) NOT NULL,
town_id INT(11) NOT NULL,
CONSTRAINT fk_stadium_towns
FOREIGN KEY stadiums(town_id)
REFERENCES towns(id));

CREATE TABLE coaches(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(10,2) NOT NULL DEFAULT 0,
coach_level INT(11) NOT NULL DEFAULT 0);

CREATE TABLE teams(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
established DATE NOT NULL,
fan_base BIGINT(20) NOT NULL,
stadium_id INT(11) NOT NULL,
CONSTRAINT fk_teams_stadiums
FOREIGN KEY teams(stadium_id)
REFERENCES stadiums(id));

CREATE TABLE skills_data(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
dribbling INT(11) DEFAULT 0,
pace INT(11) DEFAULT 0,
passing INT(11) DEFAULT 0,
shooting INT(11) DEFAULT 0,
speed INT(11) DEFAULT 0,
strength INT(11) DEFAULT 0);

CREATE TABLE players(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(20) NOT NULL,
age INT(11) NOT NULL DEFAULT 0,
position CHAR(1) NOT NULL,
salary DECIMAL(10,2) NOT NULL DEFAULT 0,
hire_date DATETIME,
skills_data_id INT(11) NOT NULL,
team_id INT(11),
CONSTRAINT fk_players_skills_data
FOREIGN KEY players(skills_data_id)
REFERENCES skills_data(id),
CONSTRAINT fk_players_teams
FOREIGN KEY players(team_id)
REFERENCES teams(id));
 CREATE TABLE players_coaches(
 player_id INT(11),
 coach_id INT(11),
 CONSTRAINT pk_players_coaches
 PRIMARY KEY (player_id, coach_id),
 CONSTRAINT fk_players_coaches_players
 FOREIGN KEY players_coaches(player_id)
 REFERENCES players(id),
 CONSTRAINT fk_players_coaches_coaches
 FOREIGN KEY players_coaches(coach_id)
 REFERENCES coaches(id));

 
 INSERT INTO coaches(first_name, last_name, salary, coach_level)
 SELECT first_name, last_name, salary*2, char_length(first_name)
 FROM players
 WHERE age>=45;
 
 UPDATE coaches
 SET coach_level = coach_level+1
 WHERE LEFT(first_name, 1) = 'A'
 AND id IN (SELECT coach_id FROM players_coaches);
 
 DELETE FROM players WHERE age>=45;
