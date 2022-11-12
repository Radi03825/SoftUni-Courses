-- 01. Records’ Count
SELECT count(*) as count FROM wizzard_deposits;

-- 02. Longest Magic Wand
SELECT max(magic_wand_size) as `longest_magic_wand` FROM wizzard_deposits;

-- 03. Longest Magic Wand per Deposit Groups
SELECT deposit_group, max(magic_wand_size) as `longest_magic_wand` FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY longest_magic_wand ASC, deposit_group;

-- 04. Smallest Deposit Group per Magic Wand Size
SELECT deposit_group FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY avg(magic_wand_size)
LIMIT 1;

-- 05. Deposits Sum
SELECT deposit_group, sum(deposit_amount) as total_sum FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY total_sum;

-- 06. Deposits Sum for Ollivander Family
SELECT deposit_group, sum(deposit_amount) as total_sum FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group;

-- 07. Deposits Filter
SELECT deposit_group, sum(deposit_amount) as total_sum FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
HAVING total_sum < 150000
ORDER BY total_sum DESC;

-- 08. Deposit Charge
SELECT deposit_group, magic_wand_creator, min(deposit_charge) FROM wizzard_deposits
GROUP BY deposit_group, magic_wand_creator
ORDER BY magic_wand_creator ASC, deposit_group;

-- 09. Age Groups
SELECT
    CASE
        WHEN age <= 10 THEN '[0-10]'
        WHEN age <= 20 THEN '[11-20]'
        WHEN age <= 30 THEN '[21-30]'
        WHEN age <= 40 THEN '[31-40]'
        WHEN age <= 50 THEN '[41-50]'
        WHEN age <= 60 THEN '[51-60]'
        ELSE '[61+]'
        END as 'age_group',
        count(*) as 'wizard_count'
FROM wizzard_deposits
GROUP BY age_group
ORDER BY wizard_count;

-- 10. First Letter
SELECT DISTINCT left(first_name, 1) as 'first_letter' FROM wizzard_deposits
WHERE deposit_group = 'Troll Chest'
ORDER BY first_letter;

-- 11. Average Interest
SELECT  deposit_group, is_deposit_expired, avg(deposit_interest) as 'average_interest' FROM wizzard_deposits
WHERE timediff("1985-01-01", deposit_start_date) < 0
GROUP BY deposit_group, is_deposit_expired
ORDER BY deposit_group DESC, is_deposit_expired ASC;

-- 12. Employees Minimum Salaries
SELECT department_id, min(salary) as 'minimum_salary' FROM employees
WHERE department_id IN (2, 5, 7) AND timediff("2000-01-01 00:00:00", hire_date) < 0
GROUP BY department_id
ORDER BY department_id ASC;

-- 13. Employees Average Salaries
SELECT department_id, if(department_id = 1, avg(salary) + 5000, avg(salary)) as 'avg_salary' FROM employees
WHERE salary > 30000 AND manager_id != 42
GROUP BY department_id
ORDER BY department_id;

-- 14. Employees Maximum Salaries
SELECT department_id, max(salary) as 'max_salary' FROM employees
GROUP BY department_id
HAVING max_salary NOT BETWEEN 30000 AND 70000
ORDER BY department_id;

-- 15. Employees Count Salaries
SELECT count(salary) FROM employees
WHERE manager_id IS NULL;

-- 16. 3rd Highest Salary
SELECT department_id, (SELECT DISTINCT salary FROM employees as e2 WHERE e1.department_id = e2.department_id ORDER BY salary DESC LIMIT 2,1) AS 'third_highest_salary' FROM employees as e1
GROUP BY department_id
HAVING third_highest_salary is NOT NULL
ORDER BY department_id;

-- 17. Salary Challenge
SELECT e.`first_name`, e.`last_name`, e.`department_id`
FROM `employees` AS e
WHERE `salary` >
      (
          SELECT AVG(e2.`salary`)
          FROM `employees` AS e2
          WHERE e2.`department_id` = e.`department_id`
      )
ORDER BY `department_id`, `employee_id`
    LIMIT 10;

-- 18. Departments Total Salaries
SELECT `department_id`, SUM(`salary`) AS `total_salary`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;