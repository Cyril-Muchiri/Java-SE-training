DROP PROCEDURE IF EXISTS depositFunds;
CREATE PROCEDURE depositFunds(IN moneyIn INT,IN memberNumber INT)
BEGIN
DECLARE current_balance INT;
    SELECT funds INTO current_balance FROM membersTable WHERE memberNumber = memberNumber;
    
    IF current_balance IS NOT NULL THEN
        UPDATE membersTable SET funds = current_balance + moneyIn WHERE memberNumber = memberNumber;
        SELECT 'Deposit successful' AS result;
    ELSE
        SELECT 'Member not found' AS result;
    END IF;
END
