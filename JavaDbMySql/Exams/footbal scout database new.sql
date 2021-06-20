SELECT first_name, age, salary FROM players
ORDER BY salary DESC;
SELECT p.id, CONCAT(p.first_name, ' ', p.last_name) AS full_name, p.age, p.`position`, p.hire_date
FROM players AS p
JOIN skills_data AS sd  ON p.skills_data_id = sd.id
WHERE p.hire_date IS NULL AND p.age < 23 AND p.`position` = 'A' AND p.hire_date IS NULL 
 AND sd.strength >50
ORDER BY p.salary, p.age ;


SELECT t.name AS team_name, t.established, t.fan_base, COUNT(p.id) AS players_count
FROM teams AS t
LEFT JOIN players AS p ON p.team_id = t.id
GROUP BY t.id
ORDER BY players_count DESC, t.fan_base DESC;

SELECT MAX(sk.speed) AS max_speed, t.name AS town_name
FROM skills_data AS sk
RIGHT JOIN players AS p ON p.skills_data_id = sk.id
RIGHT JOIN teams AS tm ON tm.id = p.team_id
JOIN stadiums AS s ON s.id = tm.stadium_id
JOIN towns AS t ON t.id = s.town_id
WHERE tm.name != 'Devify'
GROUP BY t.name
ORDER BY max_speed DESC, town_name;

SELECT c.name AS 'name', COUNT(p.id) AS total_count_of_players, SUM(p.salary) AS total_sum_of_salaries
FROM countries AS c
LEFT JOIN towns AS t on t.country_id = c.id
LEFT JOIN stadiums as s ON s.town_id = t.id
LEFT JOIN teams AS tm ON tm.stadium_id = s.id
LEFT JOIN players AS p ON p.team_id = tm.id
GROUP BY c.id
ORDER BY total_count_of_players DESC, c.name;
DELIMITER \\
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(p.id) 
FROM stadiums AS s
JOIN teams AS t ON t.stadium_id = s.id
JOIN players AS p ON p.team_id = t.id
WHERE s.name = 'stadium_name');

END\\
DELIMITER ;
SELECT udf_stadium_players_count ('Linklinks') as `count`; 

DELIMITER \\
CREATE PROCEDURE udp_find_playmaker (min_dribble_points INT, team_name_input VARCHAR(45))
BEGIN
SELECT CONCAT(p.first_name, ' ', p.last_name) AS full_name, 
p.age, p.salary, sk.dribbling, sk.speed, t.name AS team_name
FROM players AS p
JOIN skills_data AS sk ON sk.id = p.skills_data_id
JOIN teams AS t ON t.id = p.team_id
WHERE sk.dribbling > min_dribble_points AND 
t.name = team_name_input AND sk.speed > (SELECT AVG(speed) from skills_data AS sk JOIN players AS p on p.skills_data_id = sk.id)
ORDER BY speed DESC 
LIMIT 1;
END\\

DELIMITER ;
CALL udp_find_playmaker (20, 'Skyble');

SELECT players 
