-- 01. Employee Address
SELECT e.employee_id, e.job_title, a.address_id, a.address_text FROM employees as e JOIN addresses as a
ON e.address_id = a.address_id
ORDER BY address_id ASC
LIMIT 5;

-- 02. Addresses with Towns
SELECT e.first_name, e.last_name, t.name, a.address_text FROM employees as e JOIN addresses as a ON e.address_id = a.address_id JOIN towns as t ON a.town_id = t.town_id
ORDER BY first_name ASC, last_name
LIMIT 5;

-- 03. Sales Employee
SELECT e.employee_id, e.first_name, e.last_name, d.name FROM employees as e JOIN departments as d ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;

-- 04. Employee Departments
SELECT e.employee_id, e.first_name, e.salary, d.name FROM employees as e JOIN departments as d ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY e.department_id DESC
LIMIT 5;

-- 05. Employees Without Project
SELECT e.employee_id, e.first_name FROM employees as e LEFT JOIN employees_projects as ep ON e.employee_id = ep.employee_id
WHERE ep.project_id IS NULL
ORDER BY employee_id DESC
LIMIT 3;

-- 06. Employees Hired After
SELECT e.first_name, e.last_name, e.hire_date, d.name FROM employees as e JOIN departments as d ON e.department_id = d.department_id
WHERE e.hire_date > DATE("1999-01-01") AND d.name IN ('Sales', 'Finance')
ORDER BY e.hire_date ASC;

-- 07. Employees with Project
SELECT e.employee_id, e.first_name, p.name FROM employees as e JOIN employees_projects as ep ON e.employee_id = ep.employee_id
                                                               JOIN projects as p ON ep.project_id = p.project_id
WHERE DATE(p.start_date) > "2002-08-13" AND p.end_date IS NULL
ORDER BY e.first_name ASC, p.name ASC
LIMIT 5;

-- 08. Employee 24
SELECT e.employee_id, e.first_name, if(year(p.start_date) >= 2005, Null, p.name) as `project_name` FROM employees as e
    JOIN employees_projects as ep ON e.employee_id = ep.employee_id
    JOIN projects as p ON ep.project_id = p.project_id
WHERE e.employee_id = 24
ORDER BY p.name;

-- 09. Employee Manager
SELECT employee_id, first_name, manager_id, (SELECT first_name FROM employees as e2 WHERE e1.manager_id = e2.employee_id) as `manager_name` FROM employees as e1 WHERE manager_id IN (3,7)
ORDER BY first_name;

-- 10. Employee Summary
SELECT employee_id, concat(first_name, ' ', last_name) as `employee_name`, (SELECT concat(first_name, ' ', last_name) FROM employees as e2
WHERE e1.manager_id = e2.employee_id) as `manager_name`, d.name FROM employees as e1
    JOIN departments as d ON e1.department_id = d.department_id
WHERE e1.manager_id IS NOT NULL
ORDER BY employee_id
LIMIT 5;

-- 11. Min Average Salary
SELECT AVG(salary) as `avg_salary` FROM departments as d JOIN employees as e ON d.department_id = e.department_id
GROUP BY e.department_id
ORDER BY avg_salary
LIMIT 1;

-- 12. Highest Peaks in Bulgaria
SELECT mc.country_code, m.mountain_range, p.peak_name, p.elevation FROM peaks as p
    JOIN mountains_countries as mc ON p.mountain_id = mc.mountain_id
    JOIN mountains as m ON m.id = mc.mountain_id
WHERE country_code = 'BG' AND elevation > 2835
ORDER BY elevation DESC;

-- 13. Count Mountain Ranges
SELECT country_code, count(country_code) as `mountain_range` FROM mountains_countries
WHERE country_code IN ('BG', 'RU', 'US')
GROUP BY country_code
ORDER BY mountain_range DESC;

-- 14. Countries with Rivers
SELECT c.country_name, r.river_name FROM rivers as r
    JOIN countries_rivers as cr ON r.id = cr.river_id RIGHT JOIN countries as c ON cr.country_code = c.country_code
    JOIN continents ON continents.continent_code = c.continent_code
WHERE continent_name = "Africa"
ORDER BY country_name
LIMIT 5;

-- 15. Countries without any Mountains
SELECT count(c.country_code) as `country_count` FROM mountains_countries as mc RIGHT JOIN countries as c ON mc.country_code = c.country_code
WHERE mountain_id IS NULL;

-- 16. Highest Peak and Longest River by Country
SELECT c.country_name, max(p.elevation) as `highest_peak_elevation`, max(r.length) as `longest_river_length` FROM countries as c
    RIGHT JOIN mountains_countries as mc ON c.country_code = mc.country_code
    JOIN mountains as m ON mc.mountain_id = m.id JOIN peaks as p ON mc.mountain_id = p.mountain_id
    RIGHT JOIN countries_rivers as cr ON c.country_code = cr.country_code JOIN rivers as r ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC
LIMIT 5;