USE atm_db;
DROP PROCEDURE IF EXISTS selectMember;
CREATE PROCEDURE selectMember(IN memberName INT)
BEGIN
SELECT * FROM membersTable WHERE memberName=memberName;
END