SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS 'full_name', d.department_id, d.name AS department_name
FROM employees AS e
JOIN departments AS d
ON d.manager_id = e.employee_id
ORDER BY e.employee_id 
LIMIT 5;

SELECT t.town_id, t.name AS town_name, a.address_text
FROM towns AS t
JOIN addresses AS a
ON a.town_id = t.town_id
WHERE t.name IN('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id, a.address_id;

SELECT employee_id, first_name, last_name, department_id, salary
FROM employees
WHERE manager_id IS NULL;

SELECT COUNT(*) AS 'count'
FROM employees 
WHERE salary > (
SELECT AVG(salary) FROM employees);

SELECT e.employee_id, e.job_title, e.address_id, a.address_text
FROM employees AS e
JOIN addresses AS a
ON e.address_id = a.address_id
ORDER BY e.address_id
LIMIT 5;

SELECT e.first_name, e.last_name, t.name AS town, a.address_text
FROM employees AS e 
JOIN addresses AS a ON e.address_id = a.address_id 
JOIN towns AS t ON a.town_id = t.town_id
ORDER BY first_name, last_name
LIMIT 5;

SELECT e.employee_id, e.first_name, e.last_name, d.name AS department_name
FROM employees AS e
JOIN departments AS d
ON d.department_id = e.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;

SELECT e.employee_id, e.first_name, e.salary, d.name
FROM employees AS e
JOIN departments AS d
ON e.department_id = d.department_id
WHERE e.salary>15000
ORDER BY d.department_id DESC
LIMIT 5;

SELECT e.employee_id, e.first_name
FROM employees AS e
LEFT JOIN employees_projects AS ap
ON e.employee_id = ap.employee_id
WHERE ap.project_id IS null
ORDER BY e.employee_id DESC
LIMIt 3;

SELECT e.first_name, e.last_name, e.hire_date, d.name
FROM employees AS e
JOIN departments AS d
ON e.department_id = d.department_id
WHERE e.hire_date>'1999-01-01' AND d.name IN('Sales', 'Finance' )
ORDER BY hire_date;

SELECT e.employee_id, e.first_name, p.name
FROM employees AS e
JOIN employees_projects AS ap
JOIN projects AS p
ON e.employee_id = ap.employee_id AND p.project_id = ap.project_id
WHERE DATE(p.start_date) > '2002-08-13' AND p.end_date IS NULL
ORDER BY e.first_name, p.name
LIMIT 5;

SELECT e.employee_id, e.first_name, IF(YEAR(p.start_date)>=2005, NULL, p.name) AS project_name
FROM employees AS e
JOIN employees_projects AS ap
JOIN projects AS p
ON e.employee_id = ap.employee_id AND p.project_id = ap.project_id
WHERE e.employee_id = 24
ORDER BY project_name;

SELECT e.employee_id, e.first_name, e.manager_id, m.first_name
FROM employees AS e
JOIN employees AS m
ON e.manager_id = m.employee_id
WHERE e.manager_id IN(3, 7)
ORDER BY e.first_name;

SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS 'employee_name',
CONCAT(m.first_name, ' ', m.last_name) AS 'manager_name', d.name AS 'department_name'
FROM employees AS e
JOIN employees AS m ON m.employee_id = e.manager_id
JOIN departments AS d on e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;

SELECT MIN(min_average_salary) AS min_average_salary
FROM (SELECT AVG(salary) as min_average_salary
FROM employees GROUP BY department_id)
AS minsalaries;

USE geography;

SELECT mk.country_code, m.mountain_range, p.peak_name, p.elevation
FROM mountains_countries AS mk
JOIN mountains AS m ON mk.mountain_id = m.id
JOIN peaks AS p ON m.id = p.mountain_id
WHERE p.elevation > 2835 AND mk.country_code = 'BG'
ORDER BY p.elevation DESC;

SELECT c.country_code, COUNT(m.mountain_range) AS mountain_range
FROM countries AS c
JOIN mountains_countries AS mc ON c.country_code = mc.country_code
JOIN mountains as m ON mc.mountain_id = m.id
WHERE c.country_code IN('BG', 'US','RU')
GROUP BY c.country_code
ORDER BY mountain_range DESC;

SELECT c.country_name, r.river_name
FROM countries AS c
LEFT JOIN countries_rivers AS cr ON c.country_code = cr.country_code
LEFT JOIN rivers AS r ON cr.river_id = r.id
WHERE continent_code = 'AF'
ORDER BY country_name
LIMIT 5;

SELECT (COUNT(*)  - COUNT(mc.mountain_id)) AS country_count
FROM countries AS c
LEFT JOIN mountains_countries AS mc ON c.country_code = mc.country_code;

SELECT c.country_name,MAX(p.elevation) AS highest_peak_elevation, MAX(r.length) AS longest_river_length 
FROM countries AS c
LEFT JOIN mountains_countries AS mc ON c.country_code = mc.country_code
JOIN mountains AS m ON mc.mountain_id = m.id
LEFT JOIN peaks AS p ON m.id = p.mountain_id
JOIN countries_rivers AS cr ON  c.country_code = cr.country_code
LEFT JOIN rivers AS r ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, country_name ASC
LIMIT 5;
