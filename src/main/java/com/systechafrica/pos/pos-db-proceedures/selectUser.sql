use pos_db; 
DROP PROCEDURE IF EXISTS selectMember;

CREATE PROCEDURE selectMember(IN pass VARCHAR(50))
BEGIN
SELECT * FROM  postable WHERE pass=pass;
END