DROP PROCEDURE IF EXISTS depositFunds;

CREATE PROCEDURE depositFunds(IN memberNumber INT,IN pass VARCHAR(100), IN userName VARCHAR(100),accountNumber INT)
BEGIN
INSERT INTO membersTable(memberNumber,pass,userName,accountNumber)VALUES(memberNumber,pass,userName,accountNumber);
END;