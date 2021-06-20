#1
CREATE TABLE addresses
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL
);
CREATE TABLE categories
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(10) NOT NULL
);
CREATE TABLE clients
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    full_name    VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE drivers
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name  VARCHAR(30) NOT NULL,
    age        INT         NOT NULL,
    rating     FLOAT default 5.5
);

CREATE TABLE cars
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    make        VARCHAR(20) NOT NULL,
    model       VARCHAR(20),
    `year`      int         NOT NULL default 0,
    mileage     int          default 0,
    `condition` CHAR(1)     NOT NULL,
    category_id INT         NOT NULL,
    CONSTRAINT fk_cars_categories
        FOREIGN KEY (category_id)
            REFERENCES categories (id)
);

CREATE TABLE courses
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    from_address_id int      NOT NULL,
    start           DATETIME NOT NULL,
    bill            DECIMAL(10, 2) DEFAULT 10,
    car_id          INT      NOT NULL,
    client_id       INT      NOT NULL,
    CONSTRAINT fk_courss_adr
        FOREIGN KEY (from_address_id)
            REFERENCES addresses (id),
    CONSTRAINT fk_co_cars
        FOREIGN KEY (car_id)
            REFERENCES cars (id),
    CONSTRAINT fk_co_clients
        FOREIGN KEY (client_id)
            REFERENCES clients (id)

);
CREATE TABLE cars_drivers
(
    car_id    INT NOT NULL,
    driver_id INT NOT NULL,
    PRIMARY KEY (car_id, driver_id),
    CONSTRAINT fk_cars_dr_cars
        FOREIGN KEY (car_id)
            REFERENCES cars(id),
    CONSTRAINT fk_cars_dr_drivers
        FOREIGN KEY (driver_id)
            REFERENCES drivers(id)
);

#2
INSERT INTO clients(full_name, phone_number)
SELECT CONCAT(first_name, ' ', last_name) ,
       CONCAT('(088) 9999',id*2)
FROM drivers
WHERE id between 10 and 20;

#3
UPDATE cars
SET `condition` = 'C'
WHERE (mileage >= 800000 OR  mileage IS NULL) AND `year` <= 2010
AND make != 'Mercedes-Benz';
#4
DELETE from clients
WHERE id NOT IN(SELECT client_id FROM courses) AND CHAR_LENGTH(full_name) >3;

#5
SELECT make, model, `condition`
FROM cars;

#6
SELECT d.first_name, d.last_name, c.make, c.model, c.mileage
FROM drivers AS d
JOIN cars_drivers cd on d.id = cd.driver_id
JOIN cars c on c.id = cd.car_id
WHERE c.mileage IS NOT NULL
ORDER BY c.mileage DESC, d.first_name;

#7
SELECT c.id, c.make, c.mileage, COUNT(co.car_id) AS count_of_courses,
       ROUND(AVG(co.bill),2) AS 'avg_bill'
FROM cars AS c
LEFT JOIN courses co on c.id = co.car_id
GROUP BY c.id, c.make, c.mileage
HAVING count_of_courses!=2
ORDER BY count_of_courses DESC, c.id;

#8
SELECT c.full_name, COUNT(c2.car_id) AS count_of_cars, SUM(c2.bill) AS total_sum
FROM clients AS c
JOIN courses c2 on c.id = c2.client_id
WHERE SUBSTRING(full_name,2,1) = 'a'
GROUP BY c.full_name
HAVING count_of_cars>1
ORDER BY full_name;

#9
SELECT a.name,  IF (HOUR(co.start) BETWEEN 6 AND 20, 'Day', 'Night') AS day_time, SUM(bill) as bill, cl.full_name, c.make, c.model, cat.name as category_name
FROM addresses AS a
         JOIN courses co
              ON co.from_address_id = a.id
         JOIN clients cl
              ON cl.id = co.client_id
         JOIN cars c
              ON co.car_id = c.id
         JOIN categories cat
              ON cat.id = c.category_id
GROUP BY co.id

#10
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS int
DETERMINISTIC
BEGIN
    RETURN  (SELECT COUNT(c.id)
        FROM clients AS cl
        JOIN courses c on cl.id = c.client_id
        WHERE cl.phone_number =phone_num
        GROUP BY cl.id);
end;

#11
CREATE PROCEDURE udp_courses_by_address (address_name VARCHAR(100))
BEGIN
    SELECT a.name, cl.full_name,
           (CASE
                WHEN co.bill <=20 THEN 'Low'
                WHEN co.bill <=30 THEN 'Medium'
                ELSE 'High'
               END) AS level_of_bill, ca.make, ca.condition, cat.name AS cat_name
    FROM addresses AS a
             JOIN courses co on a.id = co.from_address_id
             JOIN clients cl on cl.id = co.client_id
             JOIN cars ca on co.car_id = ca.id
             JOIN categories cat on cat.id = ca.category_id
    WHERE a.name = address_name
    ORDER BY ca.make,cl.full_name;
end;
ORDER BY co.id;