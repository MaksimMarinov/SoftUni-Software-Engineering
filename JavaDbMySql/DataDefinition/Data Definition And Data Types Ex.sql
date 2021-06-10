CREATE TABLE `minions` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `age` INT(11) NOT NULL
);
CREATE TABLE `towns` (
    `town_id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);

#2
ALTER table minions
ADD column `town_id` INT(11);
ALTER table minions
ADD CONSTRAINT FOREIGN KEY (town_id)
REFERENCES towns(id);

#3
  INSERT INTO towns(id, name)
VALUES (1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');
INSERT into minions (id, name, age, town_id)
VALUES (1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);
       
#4
truncate TABLE minions;

#5
DROP TABLE minions;
DROP TABLE towns;
       