USE  atm_db;
SELECT * FROM membersTable;

CALL depositFunds(2000)

INSERT INTO membersTable(memberNumber,pass,userName,funds)VALUE(001,'Admin123','Muchiri',10000);

-- call depositFunds(10,'abcdef','Kinuthia',12345566);