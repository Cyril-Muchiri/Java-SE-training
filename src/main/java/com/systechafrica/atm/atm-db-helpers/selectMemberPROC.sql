DROP PROCEDURE IF EXISTS selectMember;
CREATE PROCEDURE selectMember(IN memberNumber INT)
BEGIN
SELECT * FROM membersTable WHERE memberNumber=memberNumber;
END