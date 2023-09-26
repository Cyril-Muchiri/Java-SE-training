use atm_db;
DROP PROCEDURE IF EXISTS withdrawFunds;
CREATE PROCEDURE withdrawFunds(IN memberNumber INT,IN moneyOut DOUBLE)
BEGIN

    DECLARE current_balance DOUBLE;
    SELECT funds INTO current_balance FROM membersTable WHERE memberNumber = memberNumber;
    UPDATE membersTable SET funds = current_balance - moneyOut WHERE memberNumber = memberNumber;
END