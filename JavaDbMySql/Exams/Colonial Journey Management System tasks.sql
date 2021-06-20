#1
INSERT INTO travel_cards (card_number,job_during_journey,colonist_id, journey_id )
SELECT (SELECT CASE
WHEN c.birth_date > '1980-01-01' THEN CONCAT(YEAR(c.birth_date), DAY(c.birth_date), SUBSTRING(c.ucn, 1,4))
ELSE CONCAT(YEAR(c.birth_date),MONTH(c.birth_date), SUBSTRING(c.ucn, 7,4))
END), (SELECT CASE
WHEN c.id%2=0 THEN 'Pilot'
WHEN c.id%3=0 THEN 'Cook'
ELSE 'Engineer'
END),c.id , SUBSTRING(c.ucn, 1,1)
FROM colonists AS c
WHERE c.id BETWEEN 96 AND 100;


#2

UPDATE journeys
SET purpose = 
CASE 
WHEN id%2=0 THEN 'Medical'
WHEN id%3=0 THEN 'Technical'
WHEN id%5=0 THEN 'Educational'
WHEN id%7=0 THEN 'Military'
ELSE purpose
END;
#3

DELETE FROM colonists
WHERE id NOT IN (SELECT tc.colonist_id FROM travel_cards AS tc);

#4
SELECT card_number, job_during_journey
FROM travel_cards
ORDER BY card_number;

#5
SELECT id, CONCAT(first_name, ' ', last_name) AS full_name, ucn
FROM colonists
ORDER BY first_name, last_name, id;

#6
SELECT id, journey_start, journey_end
FROM journeys
WHERE purpose = 'Military'
ORDER BY journey_start;

#7
SELECT c.id, CONCAT(c.first_name, ' ', c.last_name) AS full_name
FROM colonists AS c
JOIN travel_cards AS tc ON tc.colonist_id = c.id
WHERE tc.job_during_journey = 'Pilot'
ORDER BY c.id;

#8
SELECT COUNT(tc.colonist_id)
FROM journeys AS j
JOIN travel_cards AS tc ON tc.journey_id = j.id
WHERE j.purpose = 'Technical';

#9
SELECT sc.name AS spaceport_name, sp.name AS spaceship_name
FROM spaceships AS sc
JOIN journeys AS j ON sc.id = j.spaceship_id
JOIN spaceports AS sp ON sp.id = destination_spaceport_id
ORDER BY sc.light_speed_rate DESC
LIMIT 1;

#10
SELECT sp.name, sp.manufacturer
FROM spaceships AS sp
JOIN journeys AS j ON sp.id = j.spaceship_id
JOIN travel_cards AS tc ON tc.journey_id = j.id
JOIN colonists AS c ON c.id = tc.colonist_id
WHERE c.birth_date >'1989-01-01'
AND tc.job_during_journey = 'Pilot'
ORDER BY sp.name;



#11
SELECT p.name AS planet_name, sp.name AS spaceport_name
FROM planets AS p
JOIN spaceports AS sp ON sp.planet_id = p.id
JOIN journeys AS j ON j.destination_spaceport_id = sp.id
WHERE j.purpose = 'Educational'
ORDER BY sp.name DESC;

#12
SELECT p.name AS planet_name, COUNT(j.id) AS journeys_count
FROM planets AS p
JOIN spaceports AS sp ON sp.planet_id = p.id
JOIN journeys AS j ON j.destination_spaceport_id = sp.id
GROUP BY p.id
ORDER BY journeys_count DESC, planet_name;

#13
SELECT j.id, p.name AS planet_name, sp.name AS spaceport_name,j.purpose AS journey_purpose
FROM journeys AS j
JOIN spaceports AS sp ON j.destination_spaceport_id = sp.id
JOIN planets AS p ON sp.planet_id = p.id
ORDER BY DATEDIFF(journey_start, journey_end) DESC
LIMIT 1;

#14
SELECT job_during_journey
FROM travel_cards AS tc
JOIN journeys AS j ON j.id = tc.journey_id
WHERE j.id = (SELECT j.id
FROM journeys AS j
JOIN spaceports AS sp ON j.destination_spaceport_id = sp.id
JOIN planets AS p ON sp.planet_id = p.id
ORDER BY DATEDIFF(journey_start, journey_end)
LIMIT 1)
GROUP BY job_during_journey
ORDER BY COUNT(job_during_journey)
LIMIT 1;

#15
DELIMITER \\
CREATE FUNCTION udf_count_colonists_by_destination_planet (planet_name VARCHAR (30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(co.id)
FROM colonists as co
JOIN travel_cards AS tc ON tc.colonist_id = co.id
JOIN journeys AS j ON j.id = journey_id
JOIN spaceports AS sp ON sp.id = j.destination_spaceport_id
JOIN planets AS p ON p.id = sp.planet_id
WHERE p.name = planet_name);

END\\
DELIMITER ;

SELECT p.name, udf_count_colonists_by_destination_planet('Otroyphus') AS count
FROM planets AS p
WHERE p.name = 'Otroyphus';

#16

DELIMITER //
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11))
  BEGIN
    if (SELECT count(ss.name) FROM spaceships ss WHERE ss.name = spaceship_name > 0) THEN
      UPDATE spaceships ss
        SET ss.light_speed_rate = ss.light_speed_rate + light_speed_rate_increse
        WHERE name = spaceship_name;
    ELSE
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
      ROLLBACK;
    END IF;
  END //
  
DELIMITER ;
