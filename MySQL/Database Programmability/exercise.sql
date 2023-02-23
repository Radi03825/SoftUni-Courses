-- 01. Employees with Salary Above 35000
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
 SELECT first_name, last_name FROM employees
 WHERE salary > 35000
 ORDER BY first_name, last_name, employee_id ASC;
END

-- 02. Employees with Salary Above Number
CREATE PROCEDURE usp_get_employees_salary_above(number DOUBLE(15,4))
BEGIN
    SELECT first_name, last_name FROM employees
    WHERE salary >= number
    ORDER BY first_name, last_name, employee_id ASC;
END

-- 03. Town Names Starting With
CREATE PROCEDURE usp_get_towns_starting_with(string VARCHAR(50))
BEGIN
    SELECT name FROM towns
    WHERE name LIKE concat(string, "%")
    ORDER BY name;
END

-- 04. Employees from Town
CREATE PROCEDURE usp_get_employees_from_town(town VARCHAR(50))
BEGIN
    SELECT e.first_name, e.last_name FROM employees as e JOIN addresses as a ON e.address_id = a.address_id
                                                     JOIN towns as t ON t.town_id = a.town_id
    WHERE t.name = town
    ORDER BY e.first_name, e.last_name, employee_id ASC;
END

-- 05. Salary Level Function
CREATE FUNCTION ufn_get_salary_level(employee_salary DOUBLE)
    RETURNS VARCHAR(10)
    DETERMINISTIC
BEGIN
    RETURN (CASE WHEN employee_salary < 30000 THEN 'Low'
             WHEN employee_salary <= 50000 THEN 'Average'
             WHEN employee_salary > 50000 THEN 'High'
    END);
END

-- 06. Employees by Salary Level
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
    SELECT first_name, last_name FROM employees
    WHERE CASE
          WHEN salary_level = 'Low' THEN salary < 30000
          WHEN salary_level = 'Average' THEN salary >= 30000 AND salary <= 50000
          WHEN salary_level = 'High' THEN salary > 50000
          END
    ORDER BY first_name DESC, last_name DESC;
END

-- 07. Define Function
CREATE function ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
    RETURNS BIT
    RETURN word REGEXP(concat('^[', set_of_letters, ']+$'));

-- 08. Find Full Name
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
    SELECT concat(first_name, ' ', last_name) as 'full_name' FROM account_holders
    ORDER BY full_name, id ASC;
END

-- 9. People with Balance Higher Than
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(number DECIMAL)
BEGIN
    SELECT first_name, last_name FROM account_holders as ah JOIN accounts as a ON ah.id = a.account_holder_id
    GROUP BY account_holder_id
    HAVING sum(balance) > number
    ORDER BY ah.id ASC;
END

-- 10. Future Value Function
CREATE FUNCTION ufn_calculate_future_value(sum DOUBLE(10, 4), yearly_interest_rate DOUBLE, years INT)
    RETURNS DECIMAL(8, 4)
    DETERMINISTIC
BEGIN
    RETURN sum * (pow(1 + yearly_interest_rate, years));
END

-- 11. Calculating Interest
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4), yearly_interest_rate DECIMAL(19, 4), years INT)
    RETURNS DECIMAL(19, 4)
    DETERMINISTIC
BEGIN
    RETURN sum * (pow(1 + yearly_interest_rate, years));
END;

CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, yearly_interest_rate DECIMAL(19, 4))
BEGIN
    SELECT a.id, first_name, last_name, a.balance as 'current_balance', ufn_calculate_future_value(a.balance, yearly_interest_rate, 5) as 'balance_in_5_years' FROM account_holders as ah JOIN accounts as a ON ah.id = a.account_holder_id
    WHERE a.id = account_id;
END

-- 12. Deposit Money
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    IF(money_amount <= 0) THEN ROLLBACK;
    ELSE
    UPDATE `accounts` AS a
    SET balance = balance + money_amount
    WHERE a.`id` = account_id;
    END IF;
END

-- 13. Withdraw Money
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    IF(money_amount <= 0 OR
    (SELECT a.`balance` FROM `accounts` AS a WHERE a.`id` = account_id) < money_amount)
    THEN
        ROLLBACK;
    ELSE
        UPDATE `accounts` AS a
        SET balance = balance - money_amount
        WHERE a.`id` = account_id;
    END IF;
END

-- 14. Money Transfer
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(20, 4))
BEGIN
    IF (amount >= 0)
    AND
    (SELECT a.`id` FROM `accounts` AS a WHERE a.`id` = from_account_id) IS NOT NULL
    AND
    (SELECT a.`id` FROM `accounts` AS a WHERE a.`id` = to_account_id) IS NOT NULL
    THEN
    START TRANSACTION;

    UPDATE `accounts` AS a
    SET
        balance = balance - amount
    WHERE
        a.`id` = from_account_id;

    UPDATE `accounts` AS a
    SET
        balance = balance + amount
    WHERE
        a.`id` = to_account_id;

    IF(SELECT balance FROM `accounts` AS a WHERE a.`id` = from_account_id) < 0
    THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;

    END IF;
END