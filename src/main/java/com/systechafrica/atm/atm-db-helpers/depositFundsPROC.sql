DROP PROCEDURE IF EXISTS depositFunds;
CREATE PROCEDURE depositFunds(IN memberNumber INT,IN moneyIn DOUBLE)
BEGIN

    DECLARE current_balance DOUBLE;
    SELECT funds INTO current_balance FROM membersTable WHERE memberNumber = memberNumber;
    UPDATE membersTable SET funds = current_balance + moneyIn WHERE memberNumber = memberNumber;
END

-- SELECT*FROM membersTable;