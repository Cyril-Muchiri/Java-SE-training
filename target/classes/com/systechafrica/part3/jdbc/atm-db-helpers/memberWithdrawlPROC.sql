CREATE OR ALTER PROCEDURE createTablePROC( @memberNumber INT ,@pass VARCHAR(100), @userName VARCHAR(250),@accountNumber INT)
AS
BEGIN
    INSERT INTO membersTable(memberNumber,pass, userName,accountNumber) VALUES(@memberNumber,@pass, @userName,@accountNumber)
END