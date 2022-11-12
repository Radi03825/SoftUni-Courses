-- 01. Find Names of All Employees by First Name
SELECT first_name, last_name FROM employees
WHERE substring(lower(first_name), 1, 2) = 'sa'
ORDER BY employee_id;

-- 02. Find Names of All Employees by Last Name
SELECT first_name, last_name FROM employees
WHERE last_name LIKE '%ei%'
ORDER BY employee_id;

-- 03. Find First Names of All Employees
SELECT first_name FROM employees
WHERE (department_id = 3 OR department_id = 10) AND (year(hire_date) >= 1995 AND year(hire_date) <= 2005)
ORDER BY employee_id;

-- 04. Find All Employees Except Engineers
SELECT first_name, last_name FROM employees
WHERE job_title NOT LIKE '%Engineer%';

-- 05. Find Towns with Name Length
SELECT name FROM towns
WHERE char_length(name) IN (5, 6)
ORDER BY name;

-- 06. Find Towns Starting With
SELECT * FROM towns
WHERE name REGEXP '^[MmKkBbEe]'
ORDER BY name;

-- 07. Find Towns Not Starting With
SELECT * FROM towns
WHERE name REGEXP '^[^RrBbDd]'
ORDER BY name;

-- 08. Create View Employees Hired After
CREATE VIEW `v_employees_hired_after_2000` as
SELECT first_name, last_name FROM employees
WHERE year(hire_date) > 2000;

-- 09. Length of Last Name
SELECT first_name, last_name FROM employees
WHERE char_length(last_name) = 5;

-- 10. Countries Holding 'A'
SELECT country_name, iso_code FROM countries
WHERE country_name like '%a%a%a%'
ORDER BY iso_code;

-- 11. Mix of Peak and River Names
SELECT p.peak_name, r.river_name, lower(concat(left(p.peak_name, char_length(p.peak_name) - 1), r.river_name)) as mix
FROM rivers AS r, peaks AS p
WHERE lower(right(p.peak_name, 1)) = lower(left(r.river_name, 1))
ORDER BY mix;

-- 12. Games From 2011 and 2012 Year
SELECT name, date_format(start, '%Y-%m-%d') as start FROM games
WHERE year(start) in (2011, 2012)
ORDER BY start, name
LIMIT 50;

-- 13. example.User Email Providers
SELECT user_name, substring(email, locate('@', email) + 1) AS `email provider`
FROM users
ORDER BY `email provider`, user_name;

-- 14. Get Users with IP Address Like Pattern
SELECT `user_name`, `ip_address`
FROM `users`
-- WHERE `ip_address` REGEXP '[0-9]{3}\\.1[0-9]*\\.[0-9]+\\.[0-9]{3}'
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

-- 15. Show All Games with Duration
SELECT
    `name` AS 'game',
        (CASE
             WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
END) AS 'Part of the Day',
    (CASE
        WHEN `duration` <= 3 THEN 'Extra Short'
        WHEN `duration` BETWEEN 3 AND 6 THEN 'Short'
        WHEN `duration` BETWEEN 6 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END) AS 'Duration'
FROM `games`;

-- 16. Orders Table
SELECT
    `product_name`,
    `order_date`,
    ADDDATE(`order_date`, INTERVAL 3 DAY) AS 'pay_due',
        ADDDATE(`order_date`, INTERVAL 1 MONTH) AS 'deliver_due'
FROM `orders`;