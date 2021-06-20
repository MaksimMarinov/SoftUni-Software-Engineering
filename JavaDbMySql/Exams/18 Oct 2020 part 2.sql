CREATE TABLE pictures (
    id INT PRIMARY KEY AUTO_INCREMENT,
    url VARCHAR(100) NOT NULL,
    added_on DATETIME NOT NULL
);

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE,
    best_before DATE,
    price DECIMAL(10 , 2 ) NOT NULL,
    description TEXT,
    category_id INT NOT NULL,
    picture_id INT NOT NULL,
    CONSTRAINT fk_products_categories FOREIGN KEY (category_id)
        REFERENCES categories (id),
    CONSTRAINT fk_products_pictures FOREIGN KEY (picture_id)
        REFERENCES pictures (id)
);

CREATE TABLE towns (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE addresses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE,
    town_id INT NOT NULL,
    CONSTRAINT fk_towns_addresses FOREIGN KEY (town_id)
        REFERENCES towns (id)
);

CREATE TABLE stores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL UNIQUE,
    rating FLOAT NOT NULL,
    has_parking TINYINT(1) DEFAULT FALSE,
    address_id INT NOT NULL,
    CONSTRAINT fk_stores_addresses FOREIGN KEY (address_id)
        REFERENCES addresses (id)
);

CREATE TABLE products_stores (
    product_id INT NOT NULL,
    store_id INT NOT NULL,
    CONSTRAINT pk_pr_st PRIMARY KEY (product_id , store_id),
    CONSTRAINT fk_products_stores_products FOREIGN KEY (product_id)
        REFERENCES products (id),
    CONSTRAINT fk_products_stores_stores FOREIGN KEY (store_id)
        REFERENCES stores (id)
)
;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(15) NOT NULL,
    middle_name CHAR(1),
    last_name VARCHAR(20) NOT NULL,
    salary DECIMAL(19 , 2 ) DEFAULT 0,
    hire_date DATE NOT NULL,
    manager_id INT,
    store_id INT NOT NULL,
    CONSTRAINT fk_id_manager FOREIGN KEY (manager_id)
        REFERENCES employees (id),
    CONSTRAINT fk_employees_stores FOREIGN KEY (store_id)
        REFERENCES stores (id)
);


#2
INSERT INTO products_stores(product_id, store_id)
SELECT id , 1
FROM products
WHERE id NOT IN (SELECT product_id FROM products_stores);

SELECT 
    *
FROM
    stores;

SELECT 
    id
FROM
    stores
WHERE
    `name` = 'Cardguard'
        OR `name` = 'Veribet';
SELECT 
    `name`
FROM
    stores
WHERE
    id = 5;

UPDATE employees 
SET 
    manager_id = 3,
    salary = salary - 500
WHERE
    YEAR(hire_date) > '2003'
        AND store_id NOT IN (5 , 14);

DELETE FROM employees 
WHERE
    id != manager_id
    AND manager_id IS NOT NULL
    AND salary >= 6000;

SELECT 
    first_name, middle_name, last_name, salary, hire_date
FROM
    employees
ORDER BY hire_date DESC;

SELECT 
    pr.`name`,
    pr.price,
    pr.best_before,
    CONCAT(SUBSTRING(pr.`description`, 1, 10),
            '...') AS short_description,
    p.url
FROM
    products AS pr
        JOIN
    pictures AS p ON p.id = pr.picture_id
WHERE
    CHAR_LENGTH(pr.description) > 100
        AND YEAR(p.added_on) < 2019
        AND price > 20
ORDER BY pr.price DESC;

SELECT 
    s.name,
    COUNT(pr.id) AS product_count,
    ROUND(AVG(pr.price), 2) AS 'avg'
FROM
    stores AS s
        LEFT JOIN
    products_stores AS ps ON ps.store_id = s.id
        LEFT JOIN
    products AS pr ON pr.id = ps.product_id
GROUP BY s.id
ORDER BY product_count DESC , `avg` DESC , s.id;

SELECT 
    CONCAT(e.first_name, ' ', e.last_name),
    st.name,
    a.name,
    e.salary
FROM
    employees AS e
        JOIN
    stores AS st ON st.id = e.store_id
        JOIN
    addresses AS a ON a.id = st.address_id
WHERE
    e.salary < 4000
        AND CHAR_LENGTH(st.name) > 8
        AND LOCATE('a', a.name)
        AND (SELECT RIGHT(e.last_name, 1) = 'n');

SELECT 
    REVERSE(st.name),
    CONCAT(UPPER(t.name), '-', a.name) AS full_address,
    COUNT(e.id) AS employees_count
FROM
    stores AS st
        LEFT JOIN
    employees AS e ON e.store_id = st.id
        JOIN
    addresses AS a ON a.id = st.address_id
        JOIN
    towns AS t ON t.id = a.town_id
GROUP BY st.id
HAVING employees_count >= 1
ORDER BY full_address;

#10
DROP FUNCTION IF EXISTS udf_top_paid_employee_by_store;
DELIMITER \\
CREATE FUNCTION  udf_top_paid_employee_by_store(store_name VARCHAR(50)) 
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
RETURN (SELECT CONCAT_WS(' ', e.first_name, CONCAT(e.middle_name,'.'), 
e.last_name,'works in store for',(SELECT FLOOR(DATEDIFF('2020-10-18',e.hire_date)/365)),'years') AS full_info
FROM employees AS e
JOIN stores AS st ON st.id = e.store_id
WHERE st.name = store_name
ORDER BY e.salary DESC LIMIT 1);
END\\
DELIMITER ;

SELECT UDF_TOP_PAID_EMPLOYEE_BY_STORE('Stronghold') AS 'full_info';

SELECT UDF_TOP_PAID_EMPLOYEE_BY_STORE('Keylex') AS 'full_info';

#11
 DELIMITER \\
 CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
 BEGIN
  UPDATE products AS pr
 JOIN products_stores AS ps ON ps.product_id = pr.id
 JOIN stores AS st ON st.id = ps.store_id
 JOIN addresses AS a ON a.id = st.address_id
SET pr.price = 
 CASE 
 WHEN SUBSTRING(address_name, 1,1) = 0 AND a.name = address_name THEN pr.price +100
 WHEN a.name = address_name THEN pr.price +200
 ELSE pr.price
 END;
 
 END\\
 
 DELIMITER ;
 
 CALL udp_update_product_price('07 Armistice Parkway');
SELECT 
    name, price
FROM
    products
WHERE
    id = 15;

CALL udp_update_product_price('1 Cody Pass');
SELECT 
    name, price
FROM
    products
WHERE
    id = 17;

SELECT 
    `name`
FROM
    addresses
WHERE
    SUBSTRING(`name`, 1, 1) = 0;
