DROP PROCEDURE IF EXISTS depositFunds;
CREATE PROCEDURE depositFunds(IN moneyIn INT)
BEGIN

    DECLARE current_balance INT;
    SELECT funds INTO current_balance FROM membersTable WHERE memberNumber = 1;
    UPDATE membersTable SET funds = current_balance + moneyIn WHERE memberNumber = 1;
END

-- SELECT*FROM membersTable;